import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.util.Scanner;
import java.util.ArrayList;

public class ScoopUp{
		
	private static int option;
	private String answer;
	private String trash;
	private String time;
	private int day;
	private static String email;
	private static String password;
	private String seats;
	private ArrayList<Member> MemberList;
	private Member currentUser;
	
	Scanner in = new Scanner(System.in);
	
	Vehicle vehicle = new Vehicle();
	
	public static void main(String[] args){

		
		ScoopUp system = new ScoopUp();
		system.MemberList = new ArrayList<Member>();
		
		while(true){
			system.loadInfo();
			
			system.systemStart(); 	// Login/SignUp
			system.systemMain();	// Main menu
			
			system.saveInfo();
		}
		
	}
	
	/**
	 * START THE PROGRAM
	 */
	public void systemStart(){
		boolean valid = false;
		do{
			loginScreen();
			if (option == 1){
				valid = login();
			} else if (option == 2){
				signUpScreen();
				valid = true;
			} 
		}while(valid == false);
		
	}

	/**
	 * LOGIN SCREEN
	 * @return
	 */
	private int loginScreen(){
		
		System.out.println("Welcome to ScoopUp!");
		System.out.println("********LOGIN********");
		do{
			System.out.println("Press 1 to Login");
			System.out.println("Press 2 to SignUp");
			option = in.nextInt();
		}while(validInput(option) == false);
		
		return option;
	}
	
	/**
	 * Validates input for Signup or Login
	 * @param option Option picked by User
	 * @return true if valid input or false if invalid
	 */
	private boolean validInput(int option){
		if(option == 1 || option == 2){
			return true;
		}
		else{
			System.out.println("Invalid Input\n");
			return false;
		}
	}
	
//	/**
//	 * LOGIN SYSTEM
//	 * 
//	 */
	public boolean login(){
		in.nextLine(); //FLUSH
		
		System.out.println("Enter your email address: ");
		email = in.nextLine();
		currentUser = findMember(email);
		if(currentUser == null){
			System.out.println("User account does not exist!\n");
			return false;
		}
		
		//Loop for 3 tries
		int tries = 0;
		boolean validPass = false;
		while(tries < 3 && !validPass){

			System.out.println("Enter you password: ");
			String hashedPass = hashPassword(in.nextLine());
			
			if(hashedPass.equals(currentUser.getPassword())){
				validPass = true;
			}
			else{
				tries++;
				System.out.println("Invalid Password! ");
				System.out.println(3 - tries + "attempts left.\n");
				if(tries >= 3){
					System.out.println("Out of login attempts!\n");
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * SINGUP SCREEN
	 */
	private void signUpScreen(){
		in.nextLine(); //FLUSH
		
		Member temp = new Member();
		
		System.out.println("***Sign Up***");

		System.out.println("Enter your full name: ");
		temp.setName(in.nextLine());
		
		System.out.println("Enter your email address: ");
		String tempEmail = in.nextLine();
		for(Member m: MemberList){
			if(m.getEmail().equals(tempEmail.toLowerCase())){
				System.out.println("User already Exists!!\n");
				return;
			}
		}
		temp.setEmail(tempEmail.toLowerCase());
		
		System.out.println("Enter your password: ");
		String password = in.nextLine();
		temp.setPassword(hashPassword(password));

		System.out.println("Enter your full address (street, city, state, zip code): ");
		temp.setAddress(in.nextLine());
		
		System.out.println("Do you have a vehicle? (y/n)");

		/*
		 * Create a vehicle
		 */
		do{
			answer = in.nextLine();
			
			if (answer.charAt(0) == 'y'){
				temp.setHasVehicle(true);
				System.out.println("Enter vehicle's year: ");
				vehicle.setYear(in.nextLine());
				System.out.println("Enter vehicle's make: ");
				vehicle.setMake(in.nextLine());
				System.out.println("Enter vehicle's model: ");
				vehicle.setModel(in.nextLine());
				System.out.println("Enter vehicle's color: ");
				vehicle.setColor(in.nextLine());
				System.out.println("Enter number of seats: ");
				vehicle.setAvailableSeats(in.nextLine());
				temp.setVehicles(vehicle);
			} else if (answer.charAt(0) == 'n') {
				temp.setHasVehicle(false);
			} 
			else {
				//Error Message
				System.out.println("invalid Input, Try Again!\n");
			}
		}
		while(answer.charAt(0) != 'y' && answer.charAt(0) != 'n');
		
		System.out.println("You are almost done. \nLastly we need to setup your schedule for the rest of the semester.");

		
		/*
		 * MONDAY -- Pass info to memberLongTermSchedule
		 */
		String tempTime;
		do{
			System.out.println("Will you be needing a ride on Mondays? (y/n)");
			answer = in.nextLine();
		
			if (answer.equals("y")){
				System.out.println("What time do you need to be in school? (use 24 hours time)");
				tempTime = in.nextLine();
				temp.memberLongSchedule.addArrivals(0, tempTime);
				System.out.println("What time do you need to be leave school? (use 24 hours time)");
				tempTime = in.nextLine();
				//temp.memberLongSchedule.addDepartures(0, tempTime);
				
			} else if (answer.equals("n")) {
				System.out.println("");
			}else{
				System.out.println("Invalid Input, Try again!");
			}
		}while(answer.charAt(0) != 'y' && answer.charAt(0) != 'n');
		
		
		
		/*
		 * TUESDAY -- info to memberLongTermSchedule
		 */
		do {
			System.out.println("Will you be needing a ride on Tuesdays? (y/n)");
			answer = in.nextLine();
			if (answer.equals("y")){
				System.out.println("What time do you need to be in school? (use 24 hours time)");
				tempTime = in.nextLine();
				temp.memberLongSchedule.addArrivals(1, tempTime);
				System.out.println("What time do you need to be leave school? (use 24 hours time)");
				tempTime = in.nextLine();
				temp.memberLongSchedule.addDepartures(1, tempTime);
			} else if (answer.equals("n")) {
				System.out.println("");
			}else{
				System.out.println("Invalid Input, Try again!");
			}
		}while(answer.charAt(0) != 'y' && answer.charAt(0) != 'n');
		

		/*
		 * WEDNESDAY -- Pass info to memberLongTermSchedule
		 */
		do{
			System.out.println("Will you be needing a ride on Wednesdays? (y/n)");
			answer = in.nextLine();
			if (answer.equals("y")){
				System.out.println("What time do you need to be in school? (use 24 hours time)");
				tempTime = in.nextLine();
				temp.memberLongSchedule.addArrivals(2, tempTime);
				System.out.println("What time do you need to be leave school? (use 24 hours time)");
				tempTime = in.nextLine();
				temp.memberLongSchedule.addDepartures(2, tempTime);
			} else if (answer.equals("n")) {
				System.out.println("");
			}else{
				System.out.println("Invalid Input, Try again!");
			}
		}while(answer.charAt(0) != 'y' && answer.charAt(0) != 'n');

		/*
		 * Pass info to memberLongTermSchedule
		 */
		
		do{
			System.out.println("Will you be needing a ride on Thursdays? (y/n)");
			answer = in.nextLine();
			
			if (answer.equals("y")){
				System.out.println("What time do you need to be in school? (use 24 hours time)");
				tempTime = in.nextLine();
				temp.memberLongSchedule.addArrivals(3, tempTime);
				System.out.println("What time do you need to be leave school? (use 24 hours time)");
				tempTime = in.nextLine();
				temp.memberLongSchedule.addDepartures(3, tempTime);
			} else if (answer.equals("n")) {
				System.out.println("");
			}else{
				System.out.println("Invalid Input, Try again!");
			}
		}while(answer.charAt(0) != 'y' && answer.charAt(0) != 'n');

		
		/*
		 * FRIDAY -- Pass info to memberLongTermSchedule
		 */
		do{
			System.out.println("Will you be needing a ride on Fridays? (y/n)");
			answer = in.nextLine();
			
			if (answer.equals("y")){
				System.out.println("What time do you need to be in school? (use 24 hours time)");
				tempTime = in.nextLine();
				temp.memberLongSchedule.addArrivals(4, tempTime);
				System.out.println("What time do you need to be leave school? (use 24 hours time)");
				tempTime = in.nextLine();
				temp.memberLongSchedule.addDepartures(4, tempTime);
			} else if (answer.equals("n")) {
				System.out.println("");
			}else{
				System.out.println("Invalid Input, Try again!");
			}
		}while(answer.charAt(0) != 'y' && answer.charAt(0) != 'n');
		
		System.out.println("");
		System.out.println("Congratulation! You are registered with ScoopUp.");
		System.out.println("");
		
		MemberList.add(temp);
		
		//Set Currentuser
		currentUser = MemberList.get(MemberList.size() - 1);
		System.out.println(currentUser.getEmail());
		
	}

	
	/**
	 * MAIN SYSTEM
	 */
	public void systemMain(){
		int choice = -1;
		
		//LACKS ERROR CHECKING
		do{
			menuScreen();
			choice = in.nextInt();

			switch(choice){
				case 1: //viewProfileScreen();
					break;
				case 2: //requestionRides();
					break;
				case 3: //payments();
					break;
				case 4: 
					break;
				case 5: 
					break;
				case 6: editProfile();
					break;
				case 0: System.out.println("Saving Info...");
					return;
				default: System.out.println("Bad option");
					break;
			}
		}while(choice != 0);
	}
	
	/**
	 * MAIN MENU SCREEN
	 */
	private void menuScreen(){
		
		//System.out.println("Logged in as " + member.getName);
		System.out.println("***************MAIN MENU*******************");
		System.out.println("* Select an option:                       *");
		System.out.println("*   1) View Profile                       *");
		System.out.println("*   2) Be a Driver                        *");
		System.out.println("*   3) Request a Ride                     *");
		System.out.println("*   4) Payments                           *");
		System.out.println("*   5) View Profile                       *");
		System.out.println("*   6) Edit Profile                       *");
		System.out.println("*   0) Logout                             *");
		System.out.println("*                                         *");
		System.out.println("*******************************************");

	}
//	
//	/**
//	 * VIEW PROFILE SCREEN
//	 * @return
//	 */
//	private int viewProfileScreen(){
//		System.out.println("***PROFILE***\n\n");
//		
//		System.out.println("*"+m.getName()+"'s contact information*");
//		System.out.println("Status: " + m.getMemberStatus());
//		System.out.println("Preference (On Duty): " + m.isPreference());
//		System.out.println("Emial: " + m.getEmail());
//		System.out.println("Address: " + m.getAddress());
//		
//		System.out.println("*"+m.getName()+"'s vehicle information*");
//		System.out.println("Vehicle: " + m.isHasVehicle());
//		System.out.println("Vehicle: " + m.getVehicles());
//		System.out.println("Seats Available: " + vehicle.getAvailableSeats());
//		
//		System.out.println("*"+m.getName()+"'s schedule*");
//		System.out.println("TO SCHOOL:");
//		
//		//TO DO: iterate over arrivals hashmap
//		
//		System.out.println("FROM SCHOOL:");
//		// TO DO: Iterate over departures hashmap
//		
//		System.out.println("OPTIONS");
//		System.out.println("Press 1 to change status");
//		System.out.println("Press 2 to change preference");
//		System.out.println("Press 3 to edit seats available");
//		System.out.println("Press 4 to edit schedule");
//		System.out.println("Press 5 to go back to MAIN MENU");
//		option = in.nextInt();
//		return option;
//	}
//	
	public void editProfile(){
		int choice = -1;
		editProfileMenu();
		do{
			choice = in.nextInt();
		}while(choice <= 0 || choice > 3); //TODO: Error CHeck
		
		switch(choice){
			case 1: editSchedule();
				break;
			case 2: addVehicle();
				break;
			default:
				System.out.println("Invalid Option!");
				break;
		}
		return;
	}
	
	/**
	 * Profile Menu
	 */
	private void editProfileMenu(){
		System.out.println(" 1) Change Schedule ");
		System.out.println(" 2) Add Vehicle");
		//System.out.println(" 3) Delete Vehicle ");;
		
	}
	
	/**
	 * Change User Schedule
	 * NOTE: Redundant Code
	 */
	private void editSchedule(){
		
		/*
		 * MONDAY -- Pass info to memberLongTermSchedule
		 */
		do{
			System.out.println("Will you be needing a ride on Mondays? (y/n)");
			answer = in.nextLine();
		
			if (answer.equals("y")){
				System.out.println("What time do you need to be in school? (__:__ <-- use 24 hours time)");
				currentUser.memberLongSchedule.addArrivals(0, time);
				System.out.println("What time do you need to be leave school? (__:__ <-- use 24 hours time)");
				currentUser.memberLongSchedule.addDepartures(0, time);
			} else if (answer.equals("n")) {
				System.out.println("");
			}else{
				System.out.println("Invalid Input, Try again!");
			}
		}while(answer.charAt(0) != 'y' && answer.charAt(0) != 'n');
		
		
		
		/*
		 * TUESDAY -- info to memberLongTermSchedule
		 */
		do {
			System.out.println("Will you be needing a ride on Tuesdays? (y/n)");
			answer = in.nextLine();
			if (answer.equals("y")){
				System.out.println("What time do you need to be in school? (__:__ <-- use 24 hours time)");
				currentUser.memberLongSchedule.addArrivals(1, time);
				System.out.println("What time do you need to be leave school? (__:__ <-- use 24 hours time)");
				currentUser.memberLongSchedule.addDepartures(1, time);
			} else if (answer.equals("n")) {
				System.out.println("");
			}else{
				System.out.println("Invalid Input, Try again!");
			}
		}while(answer.charAt(0) != 'y' && answer.charAt(0) != 'n');
		

		/*
		 * WEDNESDAY -- Pass info to memberLongTermSchedule
		 */
		do{
			System.out.println("Will you be needing a ride on Wednesdays? (y/n)");
			answer = in.nextLine();
			if (answer.equals("y")){
				System.out.println("What time do you need to be in school? (__:__ <-- use 24 hours time)");
				currentUser.memberLongSchedule.addArrivals(2, time);
				System.out.println("What time do you need to be leave school? (__:__ <-- use 24 hours time)");
				currentUser.memberLongSchedule.addDepartures(2, time);
			} else if (answer.equals("n")) {
				System.out.println("");
			}else{
				System.out.println("Invalid Input, Try again!");
			}
		}while(answer.charAt(0) != 'y' && answer.charAt(0) != 'n');

		/*
		 * Pass info to memberLongTermSchedule
		 */
		
		do{
			System.out.println("Will you be needing a ride on Thursdays? (y/n)");
			answer = in.nextLine();
			
			if (answer.equals("y")){
				System.out.println("What time do you need to be in school? (__:__ <-- use 24 hours time)");
				currentUser.memberLongSchedule.addArrivals(3, time);
				System.out.println("What time do you need to be leave school? (__:__ <-- use 24 hours time)");
				currentUser.memberLongSchedule.addDepartures(3, time);
			} else if (answer.equals("n")) {
				System.out.println("");
			}else{
				System.out.println("Invalid Input, Try again!");
			}
		}while(answer.charAt(0) != 'y' && answer.charAt(0) != 'n');

		
		/*
		 * FRIDAY -- Pass info to memberLongTermSchedule
		 */
		do{
			System.out.println("Will you be needing a ride on Fridays? (y/n)");
			answer = in.nextLine();
			
			if (answer.equals("y")){
				System.out.println("What time do you need to be in school? (__:__ <-- use 24 hours time)");
				currentUser.memberLongSchedule.addArrivals(4, time);
				System.out.println("What time do you need to be leave school? (__:__ <-- use 24 hours time)");
				currentUser.memberLongSchedule.addDepartures(4, time);
			} else if (answer.equals("n")) {
				System.out.println("");
			}else{
				System.out.println("Invalid Input, Try again!");
			}
		}while(answer.charAt(0) != 'y' && answer.charAt(0) != 'n');
	}
	
	private void addVehicle(){
		System.out.println("Do you have a vehicle? (y/n)");

		/*
		 * Create a vehicle
		 */
		do{
			answer = in.nextLine();
			
			if (answer.charAt(0) == 'y'){
				currentUser.setHasVehicle(true);
				System.out.println("Enter vehicle's year: ");
				vehicle.setYear(in.nextLine());
				System.out.println("Enter vehicle's make: ");
				vehicle.setMake(in.nextLine());
				System.out.println("Enter vehicle's model: ");
				vehicle.setModel(in.nextLine());
				System.out.println("Enter vehicle's color: ");
				vehicle.setColor(in.nextLine());
				System.out.println("Enter vehicle's year: ");
				vehicle.setAvailableSeats(in.nextLine());
				currentUser.setVehicles(vehicle);
			} else if (answer.charAt(0) == 'n') {
				currentUser.setHasVehicle(false);
			} 
			else {
				//Error Message
				System.out.println("invalid Input, Try Again!\n");
			}
		}while(answer.charAt(0) != 'y' && answer.charAt(0) != 'n');
	}
//	/**
//	 * PROFILE SYSTEM
//	 */
//	public void systemProfile(){
//		if (option == 1) {
//			//TO DO: FIX IT
//			if (m.getMemberStatus().equals("Your status is set to a Passenger")){
//			//	m.setMemberStatus(m.memberStatus.setDriver());
//				System.out.println("Your status is set to a Driver");
//			} else {
//		//		m.setMemberStatus(m.memberStatus.setPassenger());
//				System.out.println("Your status is set to a Passenger");
//			}
//		} else if (option == 2) {
//			if (m.isPreference() == true){
//				m.setPreference(false);
//			} else {
//				m.setPreference(true);
//			}
//		} else if (option == 3) {
//			seats = in.nextInt();
//			vehicle.setAvailableSeats(seats);;
//		} else if (option == 4) {
//			System.out.println("Enter your new schedule:");
//			System.out.println("TO SCHOOL:");
//			System.out.println("Will you be needing a ride on Mondays? (y/n)");
//			answer = in.nextLine();
//			
//			/*
//			 * MONDAY -- Pass info to memberLongTermSchedule
//			 */
//			if (answer.equals("y")){
//				System.out.println("What time do you need to be in school? (__:__ <-- use 24 hours time)");
//				m.memberLongSchedule.addArrivals(0, time);
//				System.out.println("What time do you need to be leave school? (__:__ <-- use 24 hours time)");
//				m.memberLongSchedule.addDepartures(0, time);
//			} else if (answer.equals("n")) {
//				System.out.println("");
//			} else { 
//				System.out.println("Invalid ipnut!");
//			}
//			
//			System.out.println("Will you be needing a ride on Tuesdays? (y/n)");
//			answer = in.nextLine();
//			
//			/*
//			 * TUESDAY -- info to memberLongTermSchedule
//			 */
//			if (answer.equals("y")){
//				System.out.println("What time do you need to be in school? (__:__ <-- use 24 hours time)");
//				m.memberLongSchedule.addArrivals(1, time);
//				System.out.println("What time do you need to be leave school? (__:__ <-- use 24 hours time)");
//				m.memberLongSchedule.addDepartures(1, time);
//			} else if (answer.equals("n")) {
//				System.out.println("");
//			} else { 
//				System.out.println("Invalid ipnut!");
//			}
//			
//			System.out.println("Will you be needing a ride on Wednesdays? (y/n)");
//			answer = in.nextLine();
//			
//			/*
//			 * WEDNESDAY -- Pass info to memberLongTermSchedule
//			 */
//			if (answer.equals("y")){
//				System.out.println("What time do you need to be in school? (__:__ <-- use 24 hours time)");
//				m.memberLongSchedule.addArrivals(2, time);
//				System.out.println("What time do you need to be leave school? (__:__ <-- use 24 hours time)");
//				m.memberLongSchedule.addDepartures(2, time);
//			} else if (answer.equals("n")) {
//				System.out.println("");
//			} else { 
//				System.out.println("Invalid ipnut!");
//			}
//			
//			System.out.println("Will you be needing a ride on Thursdays? (y/n)");
//			answer = in.nextLine();
//			
//			/*
//			 * Pass info to memberLongTermSchedule
//			 */
//			if (answer.equals("y")){
//				System.out.println("What time do you need to be in school? (__:__ <-- use 24 hours time)");
//				m.memberLongSchedule.addArrivals(3, time);
//				System.out.println("What time do you need to be leave school? (__:__ <-- use 24 hours time)");
//				m.memberLongSchedule.addDepartures(3, time);
//			} else if (answer.equals("n")) {
//				System.out.println("");
//			} else { 
//				System.out.println("Invalid ipnut!");
//			}
//			
//			System.out.println("Will you be needing a ride on Fridays? (y/n)");
//			answer = in.nextLine();
//			
//			/*
//			 * FRIDAY -- Pass info to memberLongTermSchedule
//			 */
//			if (answer.equals("y")){
//				System.out.println("What time do you need to be in school? (__:__ <-- use 24 hours time)");
//				m.memberLongSchedule.addArrivals(4, time);
//				System.out.println("What time do you need to be leave school? (__:__ <-- use 24 hours time)");
//				m.memberLongSchedule.addDepartures(4, time);
//			} else if (answer.equals("n")) {
//				System.out.println("");
//			} else { 
//				System.out.println("Invalid ipnut!");
//			}
//			
//		} else {
//			systemMain();
//		}
//	}
//	
//	/**
//	 * RIDE REQUEST SCREEN
//	 */
//	private void requestRide(){
//		
//		System.out.println("Press 1 if you need a ride to school.");
//		System.out.println("Press 2 if you need a ride from school.");
//		System.out.println("Press 3 to go back");
//		option = in.nextInt();
//		
//		if (option == 1){
//			System.out.println("On what day to you need a ride?\nPress 1 for Monday\nPress 2 for Tuesday\nPress 3 for Wednesday\nPress 4 for Thursday\nPress 5 for Friday\nPress 6 for Saturday\nPress 7 for Sunday\n");
//			day = in.nextInt();
//			System.out.println("What time do you need to arrive to school? (Use military time, ex: 1230, 1315, 1400, etc.)");
//			time = in.nextInt();
//			m.memberLongSchedule.addArrivals(day, time);
//			System.out.println("A notification will be sent to you once driver accepts your request");
//			requestRide();
//			
//		} else if (option == 2){
//			System.out.println("On what day to you need a ride?\nPress 1 for Monday\nPress 2 for Tuesday\nPress 3 for Wednesday\nPress 4 for Thursday\nPress 5 for Friday\nPress 6 for Saturday\nPress 7 for Sunday\n");
//			day = in.nextInt();
//			System.out.println("What time do you need to leave from school? (Use military time, ex: 1230, 1315, 1400, etc.)");
//			time = in.nextInt();
//			m.memberLongSchedule.addDepartures(day, time);
//			System.out.println("A notification will be sent to you once driver accepts your request");
//			requestRide();
//		
//		} else if (option == 3) {
//			mainScreen();
//			
//		} else {
//			System.out.println("Invalid Input!");
//			requestRide();
//		}
//	}
	
	/**
	 * Save Members Info
	 */
	private void saveInfo(){
	      try
	      {
	         FileOutputStream fileOut = new FileOutputStream("members.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(MemberList);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in members.ser\n");
	    	 
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	}
	
	/**
	 * Load Members Info
	 */
	private void loadInfo(){
		try
		{
		   FileInputStream fileIn = new FileInputStream("members.ser");
		   ObjectInputStream in = new ObjectInputStream(fileIn);
		   MemberList = (ArrayList<Member>) in.readObject();
		   in.close();
		   fileIn.close();
		}catch(IOException i)
		{
			i.printStackTrace();
		   return;
		}catch(ClassNotFoundException c)
		{
		   System.out.println("Members class not found");
		   return;
		}
	}
	

	/**
	 * @return the option
	 */
	public int getOption() {
		return option;
	}
	
	
	/**
	 * Hash User Password
	 * @param pass plaintext passed in
	 * @return SHA256 pasword hashed
	 */
	private String hashPassword(String pass){
	    try{
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] hash = digest.digest(pass.getBytes("UTF-8"));
	        StringBuffer hexString = new StringBuffer();

	        for (int i = 0; i < hash.length; i++) {
	            String hex = Integer.toHexString(0xff & hash[i]);
	            if(hex.length() == 1) hexString.append('0');
	            hexString.append(hex);
	        }

	        return hexString.toString();
	    } catch(Exception ex){
	       throw new RuntimeException(ex);
	    }
	}
	
	private Member findMember(String email){
		for(Member m: MemberList){
			if(m.getEmail().contentEquals(email.toLowerCase())){
				return m;
			}
		}
		return null;
		
	}
	
	
}


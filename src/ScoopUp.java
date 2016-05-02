import java.time.DayOfWeek;
import java.util.Scanner;

public class ScoopUp {
		
	private static int option;
	private String answer;
	private String trash;
	private int time;
	private int day;
	private static String email;
	private static String password;
	private int seats;
	
	 Scanner in = new Scanner(System.in);
	
	Vehicle vehicle = new Vehicle();
	
	public static void main(String[] args) {
		
//		Member member;
//		member = new Member();
//		member.setPassenger();
//		member.setDriver();
		
		ScoopUp system = new ScoopUp();
		
		system.systemStart(); 	// Login/SignUp
//		system.systemMain();	// Main menu
		
	}
	
	/**
	 * START THE PROGRAM
	 */
	//TODO: Needs to be 
	public void systemStart(){
		loginScreen();
			if (option == 1){
		//	login();
		} else if (option == 2){
			signUpScreen();
			systemStart();
		} else {
			System.out.println("Invalid Input!");
			systemStart();
		}
	}

	/**
	 * LOGIN SCREEN
	 * @return
	 */
	private int loginScreen(){
		
		System.out.println("Welcome to ScoopUp!");
		System.out.println("***LOGIN***");
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
//	 * @return
//	 */
//	public int login(){
//		if (option == 1) {
//			//TO DO: Implement login
//			in.nextLine();
//			//System.out.println(m.getEmail() +" "+ m.getPassword());//TEST
//			System.out.println("Enter your email address: ");
//			email = in.nextLine();
//			m.setEmail(email);
//			System.out.println("Enter you password: ");
//			password = in.nextLine();
//			m.setPassword(password);
//			
//			if (email.equals(m.getEmail()) && password.equals(m.getPassword())){
//				system.mainScreen();
//			}
//			else {
//				System.out.println("Invalid user credentials!");
//			}
//			
//			return option;
//		} else if (option == 2) {
//			signUpScreen();
//			return 1;		
//		} else {
//			System.out.println("Invalid input!");
//			return 1;
//		}
//	}
	
	/**
	 * SINGUP SCREEN
	 */
	private void signUpScreen(){
		in.nextLine(); //FLUSH
		
		Member temp = new Member();
		
		System.out.println("***Sign Up***");
		System.out.println("Would you like to be a driver? (y/n) \nNote: This option can be changed later in User's Profile");
		answer = in.nextLine();
		
		/*
		 * Set member status to driver or passenger
		 */
		if (answer.equals("y")) {
			temp.setDriver();
			//temp.setMemberStatus(p);
		} else if (answer.equals("n")) {
			temp.setPassenger();
		}
		else {
			System.out.println("Invalid input!");
		}
		
		System.out.println("Enter your full name: ");
		temp.setName(in.nextLine());
		System.out.println("Enter your email address: ");
		temp.setEmail(in.nextLine());
		System.out.println("Enter your password: ");
		temp.setPassword(in.nextLine());
		System.out.println("Enter your full address (street, city, state, zip code): ");
		temp.setAddress(in.nextLine());
		System.out.println("Do you have a vehicle? (y/n)");
		answer = in.nextLine();
		
		/*
		 * Create a vehicle
		 */
		do{
			if (answer.charAt(0) == 'y'){
				temp.setHasVehicle(true);
				System.out.println("Enter vehicle's year: ");
				vehicle.setYear(in.nextInt());
				System.out.println("Enter vehicle's make: ");
				vehicle.setMake(in.nextLine());
				System.out.println("Enter vehicle's model: ");
				vehicle.setModel(in.nextLine());
				System.out.println("Enter vehicle's color: ");
				vehicle.setColor(in.nextLine());
				System.out.println("Enter vehicle's year: ");
				vehicle.setAvailableSeats(in.nextInt());
				temp.setVehicles(vehicle);
			} else if (answer.charAt(0) == 'n') {
				temp.setHasVehicle(false);
			} 
			else {
				//Error Message
				System.out.println("invalid Input, Try Again!\n");
			}
		}while(answer.charAt(0) != 'y' || answer.charAt(0) != 'n');
		
		System.out.println("You are almost done. \nLastly we need to setup your schedule for the rest of the semester.");
		System.out.println("Will you be needing a ride on Mondays? (y/n)");
		answer = in.nextLine();
		
		/*
		 * MONDAY -- Pass info to memberLongTermSchedule
		 */
		if (answer.equals("y")){
			System.out.println("What time do you need to be in school? (__:__ <-- use 24 hours time)");
			temp.memberLongSchedule.addArrivals(0, time);
			System.out.println("What time do you need to be leave school? (__:__ <-- use 24 hours time)");
			temp.memberLongSchedule.addDepartures(0, time);
		} else if (answer.equals("n")) {
			System.out.println("");
		} else { 
			System.out.println("Invalid ipnut!");
		}
		
		System.out.println("Will you be needing a ride on Tuesdays? (y/n)");
		answer = in.nextLine();
		
		/*
		 * TUESDAY -- info to memberLongTermSchedule
		 */
		if (answer.equals("y")){
			System.out.println("What time do you need to be in school? (__:__ <-- use 24 hours time)");
			temp.memberLongSchedule.addArrivals(1, time);
			System.out.println("What time do you need to be leave school? (__:__ <-- use 24 hours time)");
			temp.memberLongSchedule.addDepartures(1, time);
		} else if (answer.equals("n")) {
			System.out.println("");
		} else { 
			System.out.println("Invalid ipnut!");
		}
		
		System.out.println("Will you be needing a ride on Wednesdays? (y/n)");
		answer = in.nextLine();
		
		/*
		 * WEDNESDAY -- Pass info to memberLongTermSchedule
		 */
		if (answer.equals("y")){
			System.out.println("What time do you need to be in school? (__:__ <-- use 24 hours time)");
			temp.memberLongSchedule.addArrivals(2, time);
			System.out.println("What time do you need to be leave school? (__:__ <-- use 24 hours time)");
			temp.memberLongSchedule.addDepartures(2, time);
		} else if (answer.equals("n")) {
			System.out.println("");
		} else { 
			System.out.println("Invalid ipnut!");
		}
		
		System.out.println("Will you be needing a ride on Thursdays? (y/n)");
		answer = in.nextLine();
		
		/*
		 * Pass info to memberLongTermSchedule
		 */
		if (answer.equals("y")){
			System.out.println("What time do you need to be in school? (__:__ <-- use 24 hours time)");
			temp.memberLongSchedule.addArrivals(3, time);
			System.out.println("What time do you need to be leave school? (__:__ <-- use 24 hours time)");
			temp.memberLongSchedule.addDepartures(3, time);
		} else if (answer.equals("n")) {
			System.out.println("");
		} else { 
			System.out.println("Invalid ipnut!");
		}
		
		System.out.println("Will you be needing a ride on Fridays? (y/n)");
		answer = in.nextLine();
		
		/*
		 * FRIDAY -- Pass info to memberLongTermSchedule
		 */
		if (answer.equals("y")){
			System.out.println("What time do you need to be in school? (__:__ <-- use 24 hours time)");
			temp.memberLongSchedule.addArrivals(4, time);
			System.out.println("What time do you need to be leave school? (__:__ <-- use 24 hours time)");
			temp.memberLongSchedule.addDepartures(4, time);
		} else if (answer.equals("n")) {
			System.out.println("");
		} else { 
			System.out.println("Invalid ipnut!");
		}
		
		if (temp.getMemberStatus().equals("Your status is set to driver")){
			System.out.println("Would you like to change your preference to ON DUTY? (y/n)");
			if (in.nextLine().equals("y")){
				temp.setPreference(true);
				System.out.println("You are ON DUTY!");
			} else if (in.nextLine().equals("n")){
				temp.setPreference(false);
				System.out.println("You are OFF DUTY! You may change your preference in your Profile");
			} else {
				System.out.println("Invalid Input!");
			}
		}
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("Congratulation! You are registered with ScoopUp.");
		System.out.println("\n");
		System.out.println("\n");
	}
	
	/**
	 * MAIN MENU SCREEN
	 * @return
	 */
	private int mainScreen(){
		
		//System.out.println("Logged in as " + member.getName);
		System.out.println("***MAIN MENU***");
		System.out.println("Press 1 to View Profile");
		System.out.println("Press 2 to Request a Ride");
		System.out.println("Press 3 for Payments");
		System.out.println("Press 4 to Logout");
		option = in.nextInt();
		return option;
	}
	
//	/**
//	 * MAIN SYSTEM
//	 */
//	public void systemMain() {
//		mainScreen();
//		if (option == 1){
//			viewProfileScreen();
//		} else if (option == 2){
//			requestRide();
//		} else if (option == 3){
//		//payments();
//		} else if (option == 4){
//			systemStart();
//		} else {
//			System.out.println("Invalid Input");
//			systemMain();
//		}
//	
//	}
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
	 * @return the option
	 */
	public int getOption() {
		return option;
	}
	
	/**
	 * @param option the option to set
	 */
	public void setOption(int option) {
		this.option = option;
	}
	
}

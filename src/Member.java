/***
 * For the Purpose of this project, "destination" will be set to SJSU
 * Latitude: 37.3244939,
 * Longitude: -121.8818703
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Member extends MemberAbstraction implements Comparable<Member>, java.io.Serializable {
	
	private final String schoolCoordinates = "37.3244939,-121.8818703";
	private String name;
	private String email;
	private String password;
	
	private String address;
	private String city;
	private String State;
	private String zipCode; //Useless
	private String homeCoordinates;
	
	private int distanceToSchool;
	private int timeToSchool;
	
	private boolean hasVehicle;
	private boolean preference;
	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	private Vehicle vehicle;
	
	private Boolean status; //set status of Member false if passenger true if driver
	
	float points;
	int rides; //update as soon as new rides are done
	
	protected MemberSchedule memberLongSchedule;
	protected MemberSchedule memberShortSchedule;
	
	private RideManagementSystem rideSchedule;
	
	/**
	 * Constructor
	 */
	public Member(){
		memberLongSchedule = new MemberLongTermSchedule();
		memberShortSchedule = new MemberShortTermSchedule();
		
		status = false;
		points = 0;
		rides = 0;
	}
	
	/*****************************
	 *****************************
	 **   PUT MUTATORS HERE
	 *****************************
	 *****************************/
	/*************************************
	 **    SET PERSONAL INFORMATION     **
	 *************************************/
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		StringTokenizer st = new StringTokenizer(address, ",");

			this.address = st.nextElement().toString();
			this.city = st.nextElement().toString().substring(1);
			this.State = st.nextElement().toString().substring(1);
			this.zipCode = st.nextElement().toString().substring(1);
			
			try {
				setHome();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}
	
	/**
	 * @throws IOException 
	 * 
	 */
	private void setHome() throws IOException{
		FindLocation fl = new FindLocation();
		
		homeCoordinates = fl.findCoordinates(address + "+" + city + "+" + State);
	}
	
	/**
	 * @throws IOException 
	 * 
	 */
	public void setTimeandDistance() throws IOException{
		FindLocation fl = new FindLocation();
		
		fl.findDistanceTime(getCoordinates(), schoolCoordinates);
		distanceToSchool = fl.getDistance();
		timeToSchool = fl.getTime();
		
	}
	
	public void setArrivals(int day, String time){
		this.memberLongSchedule.addArrivals(day, time);
	}
	
	public void setPassenger(){
		status = false;
	}
	
	public void setDriver(){
		if(vehicles.size() > 0){
			status = true;
		}
		else{
			System.out.println("Cannot set to Driver!\nYou have no vehicles to drive!");
		}
	}
	/***************************************
	 **         SET VEHICLES              **
	 **************************************/
	/**
	 * Add vehicle to array of vehicles
	 * @param newVehicle vehicle to be added
	 */
//	public void setVehicles(Vehicle newVehicle){
//		vehicles.add(newVehicle);
//	}
	
	/*****************************
	 *****************************
	 **   PUT ACCESSORS HERE
	 *****************************
	 *****************************/
	
	/*************************************
	 **    GET PERSONAL INFORMATION     **
	 *************************************/
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @return the password?
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Get home coordinates of user
	 * @return
	 */
	public String getCoordinates(){
		return homeCoordinates;
	}
	
	/**
	 * Gets status of User
	 * @return status True is Driver, False is Passenger
	 */
	public boolean getStatus(){
		if(status == true){
			System.out.println("You are a Driver");
			return status;
		}
		else{
			System.out.println("You are a Passenger");
			return status;
		}
	}

	public String getArrivalTimes(Integer day){
		return memberLongSchedule.getArrivals(day);
	}
	
	public String getDepartureTimes(Integer day){
		return memberLongSchedule.getDepartures(day);
	}

	/************************************
	 **         GET VEHICLES           **
	 ***********************************/

	public int getNumSeats(){
		return vehicle.getSeatsLeft();
	}
	

	/**
	 * 
	 * payType False is creditCard, True is points
	 */
	@Override
	public boolean payDriver(float amt, boolean payType) {
		if(payType = true){
			if(points <= 0){
				return false;
			}
			else{
				points -= amt;
				return true;
			}
		}
		else{
			//Assume unlimited funds in credit card
			System.out.println("Paid by Credit Card");
			return true;
		}
	}
	
	public void addPoints(float amt){
		points += amt;
		
	}

	public void rideComplete(){
		rides++;
		if (rides % 10 == 0){
			points += 2;
		}
	}


	/**
	 * @return the hasVehicle
	 */
	public boolean isHasVehicle() {
		return hasVehicle;
	}

	/**
	 * @param hasVehicle the hasVehicle to set
	 */
	public void setHasVehicle(boolean hasVehicle) {
		this.hasVehicle = hasVehicle;
	}

	/**
	 * @return the vehicles
	 */
	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}

	/**
	 * @param vehicles the vehicles to set
	 */
	public void setVehicles(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	/**
	 * Add Vehicle into vehicle
	 * @param vehicle
	 */
	public void addVehicle(Vehicle vehicle){
		vehicles.add(vehicle);
		if(vehicles.size() == 1){
			setVehicles(vehicle);
		}
	}
	/**
	 * @return the preference
	 */
	public boolean isPreference() {
		return preference;
	}



	/**
	 * @param preference the preference to set
	 */
	public void setPreference(boolean preference) {
		this.preference = preference;
	}


	@Override
	public void addArrivals(int day, int time) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void addDepartures(int day, int time) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public int compareTo(Member o) {
		// TODO Auto-generated method stub
		
		return 0;
	}

}
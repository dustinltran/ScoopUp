import java.util.ArrayList;
import java.util.HashMap;

public class Member extends MemberAbstraction {
	
	private String name;
	private String email;
	private String password;
	private String address;
	private Vehicle vehicle;
	private boolean hasVehicle;
	private boolean preference;
	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	private HashMap<Integer, Integer> arrivals;
	private HashMap<Integer, Integer> departures;
	
	
	MemberStatus memberStatus;
	float points;
	int rides; //update as soon as new rides are done
	
	MemberSchedule memberLongSchedule;
	MemberSchedule memberShortSchedule;
	
	
	public Member(){
		memberStatus = new Passenger(this);
		
		memberLongSchedule = new MemberLongTermSchedule();
		memberShortSchedule = new MemberShortTermSchedule();
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
		this.address = address;
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
	 * @return the password
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

	/************************************
	 **         GET VEHICLES           **
	 ***********************************/

	
	/************
	 * WHat??
	 */
	public void setPassenger() {
		
		System.out.println(memberStatus.setPassenger());
	}
	
	public void setDriver() {
		System.out.println(memberStatus.setDriver());
	}
	
	public void setMemberStatus(MemberStatus ms) {
		memberStatus = ms;
	}
	
	public MemberStatus getMemberStatus() {
		return memberStatus;
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



	/**
	 * @return the arrivals
	 */
	public HashMap<Integer, Integer> getArrivals() {
		return arrivals;
	}



	/**
	 * @param arrivals the arrivals to set
	 */
	public void setArrivals(HashMap<Integer, Integer> arrivals) {
		this.arrivals = arrivals;
	}



	/**
	 * @return the departures
	 */
	public HashMap<Integer, Integer> getDepartures() {
		return departures;
	}



	/**
	 * @param departures the departures to set
	 */
	public void setDepartures(HashMap<Integer, Integer> departures) {
		this.departures = departures;
	}

}
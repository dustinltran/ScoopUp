import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class RideManagementSystem {
	
	private ArrayList<RideSchedule> RideSchedules;
	private ArrayList<Member> drivers;
	private ArrayList<Member> passengers;
	private String timeSchedule[][][];
	String [][] mondaySchedule  = new String[10][10];
	String [][] tuesdaySchedule  = new String[10][10];
	String [][] wednesdaySchedule  = new String[10][10];
	String [][] thursdaySchedule  = new String[10][10];
	String [][] fridaySchedule  = new String[10][10];
//	Member m = new Member();
	FindLocation fl = new FindLocation();
	
	Calendar now = Calendar.getInstance();
	int year = now.get(Calendar.YEAR);
	int month = now.get(Calendar.MONTH) + 1; 
	int day = now.get(Calendar.DAY_OF_MONTH);
	int hour = now.get(Calendar.HOUR_OF_DAY);
	int minute = now.get(Calendar.MINUTE);
	int second = now.get(Calendar.SECOND);
	
	
	
	
	
	
	
	//////////////////////// meaningless stuff below ///////////////////////////////////////
	
	ParkingGarage parking;
	
	/**
	 * Constructor
	 */
	public RideManagementSystem(){
		RideSchedules = new ArrayList<RideSchedule>();
		parking = new ParkingGarage(20, 0);
	}
	
	/**
	 * Split Passengers from Drivers
	 * @param members
	 */
	public void SplitPassengersFromDrivers(ArrayList<Member> members){
		findDrivers(members);
		findPassengers(members);
		
		timeSchedule = new String[5][drivers.size()][passengers.size()];
	}
	/**
	 * Set Schedule
	 * @throws NumberFormatException 
	 * @throws IOException 
	 */
	public void setSchedule() throws NumberFormatException, IOException{
		Integer members[] = new Integer[drivers.size()];
		ArrayList<String> tempLocations = new ArrayList<String>();
		int currDriver = -1;
		int currTime = 99999999;
		for(int i = 0; i < 5; i++){
			timeSchedule[i] = setDaySchedule(timeSchedule[i], i);
		}
		
		for(int a = 0; a < drivers.size(); a++){
			tempLocations.add(drivers.get(a).getCoordinates());
		}
		
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < passengers.size(); j++){
				for(int k = 0; (k < drivers.size()) && (drivers.get(k).getNumSeats() > 0); k++){
					if( (fl.findDistanceTime(drivers.get(k).getAddress(), passengers.get(j).getAddress())/60   ) < 10 &&
								Integer.parseInt(timeSchedule[i][k][j]) > currTime){
						currDriver = k;
					}
				}
				
				RideSchedule tempRider = new RideSchedule(drivers.get(currDriver));
				tempRider.addPassengers(passengers.get(j));
				currDriver = -1;
			}
					
		}
		
	}
	
	
	
	public void setSchedule(Member member) throws IOException{
		setMondaySchedule(member);
		setTuesdaySchedule(member);
		setWednesdaySchedule(member);
		setThursdaySchedule(member);
		setFridaySchedule(member);
	}
	
	private void setFridaySchedule(Member member) throws IOException {
		// TODO Auto-generated method stub
		if(member.isHasVehicle()){//if member has a vehicle
			
			
		}else{ // if the member is always is a passenger
			for(int i = 0; i < drivers.size(); i++){
				if(drivers.get(i).getArrivalTimes(4) == member.getArrivalTimes(4) ) {
					// also check for location on map later
					if( (fl.findDistanceTime(member.getAddress(), drivers.get(i).getAddress())/60   ) < 10 ){ 
						// match found here. set up passenger and driver if driver has enough seats. 
						
					}
				}
			}
			
		}
	}
	
//	public void fridayHelper(Member driver, Member pass){
//		if (driver.getNumSeats()  > 0 ){
//			driver.getVehicle().
//		}
//	}

	private void setThursdaySchedule(Member member) {
		// TODO Auto-generated method stub
		
	}

	private void setWednesdaySchedule(Member member) {
		// TODO Auto-generated method stub
		
	}

	private void setTuesdaySchedule(Member member) {
		// TODO Auto-generated method stub
		
	}

	public void setMondaySchedule(Member member){
		
	}
	
	
	/**
	 * Set day of schedule
	 * @param driverSchedule
	 * @param day
	 * @return
	 */
	private String[][] setDaySchedule(String driverSchedule[][], Integer day){
		FindLocation fl = new FindLocation();
		String schedule[][] = new String[drivers.size()][passengers.size()];
		for(int i = 0; i < drivers.size(); i++){
			for(int j = 0; j < passengers.size(); j++){
				try {
					if(drivers.get(i).getArrivalTimes(day) != null && passengers.get(i).getArrivalTimes(day) != null);
						fl.findDistanceTime(drivers.get(i).getCoordinates(), passengers.get(j).getCoordinates());
						driverSchedule[i][j] = Integer.toString(fl.getTime());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return schedule;
	}
	
	/**
	 * Get drivers from members list
	 * @param members
	 * @return
	 */
	private void findDrivers(ArrayList<Member> members){
		for(Member m: members){
			
			if(m.getStatus() == true){
				drivers.add(m);
			}
		}
	}
	
	/**
	 * Get Passengers from members list
	 * @param members
	 * @return
	 */
	private void findPassengers(ArrayList<Member> members){
		for(Member m: members){
			if(m.getStatus() == false){
				passengers.add(m);
			}
		}
	}
	
	/**
	 * Private Inner Class to save Distance and Time
	 * 
	 */
	private class MemberDistance{
		private int distance;
		private int time;
		
		private MemberDistance(){
			
		}
		
		public void setDistance(int distance){
			this.distance = distance;
		}
		
		public void setTime(int time){
			this.time = time;
		}
		public int getDistance(){
			return distance;
		}
		
		public int getTime(){
			return time;
		}
	}
	
	/**
	 * Parking assignment
	 */
	
	
}

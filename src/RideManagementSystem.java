import java.io.IOException;
import java.util.ArrayList;

public class RideManagementSystem {
	private ArrayList<RideSchedule> RideSchedules;
	
	private ArrayList<Member> drivers;
	private ArrayList<Member> passengers;
	
	private String timeSchedule[][][];
	
	/**
	 * Constructor
	 */
	public RideManagementSystem(){
		RideSchedules = new ArrayList<RideSchedule>();

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
	 */
	public void setSchedule(){
		int currDriver;
		int currTime = 99999999;
		for(int i = 0; i < 5; i++){
			timeSchedule[i] = setDaySchedule(timeSchedule[i], i);
		}
		
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < passengers.size(); j++){
				for(int k = 0; (k < drivers.size()) && (drivers.get(k).getNumSeats() > 0); k++){
					if(Integer.parseInt(timeSchedule[i][k][j]) > currTime){
						currDriver = k;
					}
				}
				
			}
					
		}
		
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
	
}

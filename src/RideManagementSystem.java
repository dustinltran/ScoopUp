import java.util.ArrayList;

public class RideManagementSystem {
	private ArrayList<RideSchedule> RideSchedules;
	
	private ArrayList<Member> drivers;
	private ArrayList<Member> passengers;
	
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
	}
	
	public void setSchedule(){
		String timeSchedule[][] = new String[drivers.size()][passengers.size()];
		
		
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
	
}

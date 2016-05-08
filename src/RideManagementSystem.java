import java.util.ArrayList;

public class RideManagementSystem {
	ArrayList<ScheduleStrategy> RideSchedules;
	
	ArrayList<Member> drivers;
	ArrayList<Member> passengers;
	
	public RideManagementSystem(){
		RideSchedules = new ArrayList<ScheduleStrategy>();

	}
	/**
	 * Split Passengers from Drivers
	 * @param members
	 */
	public void SplitPassengersFromDrivers(ArrayList<Member> members){
		findDrivers(members);
		findPassengers(members);
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

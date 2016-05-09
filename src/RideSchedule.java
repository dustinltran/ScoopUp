import java.util.ArrayList;

public class RideSchedule {

	private ScheduleStrategy schedule;
	
	private ArrayList<Member> passengers;
	private Member driver;
	
	
	/**
	 * Constructor
	 */
	public RideSchedule(Member driver){
		passengers = new ArrayList<Member>();
		setDriver(driver);
	}
	
	private void setDriver(Member driver){
		
	}
	
	public void setSchedule(){
		schedule = new LongTermSchedule();
		
		schedule.createSchedule(driver, passengers);
	}

	public void addPassengers(Member pass){
		passengers.add(pass);
	}
	
	
}

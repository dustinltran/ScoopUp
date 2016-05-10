import java.util.ArrayList;

public class RideSchedule {

	private ScheduleStrategy schedule;
	private ArrayList<Member> passengers;
	private Member driver;
	private int seatsLeft;
	
	
	/**
	 * Constructor
	 */
	public RideSchedule(Member driver){
		passengers = new ArrayList<Member>();
		seatsLeft = driver.getNumSeats();
		setDriver(driver);

	}
	
	private void setDriver(Member driver){
		this.driver = driver;
	}
	
	public void setSchedule(){
		schedule = new LongTermSchedule();
		
		schedule.createSchedule(driver, passengers);
	}

	public void addPassengers(Member pass){
		passengers.add(pass);
		seatsLeft--;

	}
	
	public void createSchedule(boolean term){
		schedule = setScheduleStrategy(term);
		schedule.createSchedule(driver, passengers);
		
	}
	
	public ScheduleStrategy setScheduleStrategy(boolean term){
		
		if(term == true){
			return new LongTermSchedule();
		}
		else if(term == false){
			return new ShortTermSchedule();
		}
		else
			return null;
		
	}
	
}

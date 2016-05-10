import java.io.IOException;
import java.util.ArrayList;

public class RideSchedule {

	private ScheduleStrategy schedule;
	private Member driver;
	private int seatsLeft;
	private Integer earliestTime;
	private String rawLeaveTime;
	
	private ArrayList<ArrayList<Member>> passengers;
	//private Member[]<ArrayList<Member>> passengers = new Member[5]<ArrayList<Member>>();
	
	//private Member[][] = new Member[5][]
//	private 
	
	/**
	 * Constructor
	 */
	public RideSchedule(Member driver){
		
		passengers = new ArrayList<ArrayList<Member>>();
		for(int i = 0; i < 5; i++){
			ArrayList<Member> temp = new ArrayList<Member>();
			passengers.add(temp);
		}
		seatsLeft = driver.getNumSeats();
		setDriver(driver);

	}
	
	private void setDriver(Member driver){
		this.driver = driver;
	}
	
	public void setSchedule(int day) throws IOException{
		
		earliestTime = schedule.createSchedule(driver, passengers.get(day), day);
		rawLeaveTime = schedule.leaveTime(driver, passengers.get(day), earliestTime.toString());
	}

	public void addPassengers(Member pass, int day){
		passengers.get(day).add(pass);
		seatsLeft--;

	}
	
	public void createSchedule(boolean term, int day){
		schedule = setScheduleStrategy(term);
		schedule.createSchedule(driver, passengers.get(day), day);
		
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

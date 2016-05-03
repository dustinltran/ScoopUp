import java.util.HashMap;

public class MemberLongTermSchedule extends MemberSchedule {

	private HashMap<Integer, String> longTermArrivals;
	private HashMap<Integer, String> longTermDepartures;

	private int day;
	private String time;
	
	/**
	 * @param day
	 * @param time
	 */
	public MemberLongTermSchedule() {
		super();
	}

	
	@Override
	public void addArrivals(int day, String time) {
		longTermArrivals.put(day, time);
		
	}

	@Override
	public void addDepartures(int day, String time) {
		longTermDepartures.put(day, time);

	}
}


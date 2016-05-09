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
		longTermArrivals = new HashMap<Integer, String>();
		longTermDepartures = new HashMap<Integer, String>();
	}

	
	@Override
	public void addArrivals(int day, String time) {
		longTermArrivals.put(day, time);
		
	}

	@Override
	public void addDepartures(int day, String time) {
		longTermDepartures.put(day, time);

	}
	
	public String getArrivals(Integer day){
		return longTermArrivals.get(day);
	}
	
	public String getDepartures(Integer day){
		return longTermArrivals.get(day);
	}

}


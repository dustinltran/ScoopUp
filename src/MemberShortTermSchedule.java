import java.util.HashMap;

public class MemberShortTermSchedule extends MemberSchedule{

	private HashMap<Integer, String> shortTermArrivals;
	private HashMap<Integer, String> shortTermDepartures;

	private int day;
	private String time;
	
	/**
	 * @param day
	 * @param time
	 */
	public MemberShortTermSchedule() {
		super();
		shortTermArrivals = new HashMap<Integer, String>();
		shortTermDepartures = new HashMap<Integer, String>();
	}

	
	@Override
	public void addArrivals(int day, String time) {
		shortTermArrivals.put(day, time);
		
	}

	@Override
	public void addDepartures(int day, String time) {
		shortTermDepartures.put(day, time);

	}
	
	public String getArrivals(Integer day){
		return shortTermArrivals.get(day);
	}
	
	public String getDepartures(Integer day){
		return shortTermDepartures.get(day);
	}

}


import java.util.HashMap;

public class MemberShortTermSchedule extends MemberSchedule{

	private HashMap<Integer, String> shortTermArrivals;
	private HashMap<Integer, String> shortTermDepartures;

	private int day;
	private String time;
	
	
	/**
	 * @param shortTermSchedule
	 */
	public MemberShortTermSchedule() {
		super();
	}

	
	@Override
	public void addArrivals(int day, String time) {
		
		shortTermArrivals.put(day, time);
		
	}

	@Override
	public void addDepartures(int day, String time) {
		
		shortTermDepartures.put(day, time);
		
	}

	/**
	 * @return the shortTermDepartures
	 */
	public HashMap<Integer, String> getShortTermDepartures() {
		return shortTermDepartures;
	}

	/**
	 * @param shortTermDepartures the shortTermDepartures to set
	 */
	public void setShortTermDepartures(HashMap<Integer, String> shortTermDepartures) {
		this.shortTermDepartures = shortTermDepartures;
	}


	/**
	 * @return the shortTermArrivals
	 */
	public HashMap<Integer, String> getShortTermArrivals() {
		return shortTermArrivals;
	}


	/**
	 * @param shortTermArrivals the shortTermArrivals to set
	 */
	public void setShortTermArrivals(HashMap<Integer, String> shortTermArrivals) {
		this.shortTermArrivals = shortTermArrivals;
	}

}

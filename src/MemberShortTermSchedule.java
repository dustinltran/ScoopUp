import java.util.HashMap;

public class MemberShortTermSchedule extends MemberSchedule{

	private HashMap<Integer, Integer> shortTermArrivals;
	private HashMap<Integer, Integer> shortTermDepartures;

	private int day;
	private int time;
	
	
	/**
	 * @param shortTermSchedule
	 */
	public MemberShortTermSchedule() {
		super();
	}

	
	@Override
	public void addArrivals(int day, int time) {
		
		shortTermArrivals.put(day, time);
		
	}

	@Override
	public void addDepartures(int day, int time) {
		
		shortTermDepartures.put(day, time);
		
	}

	/**
	 * @return the shortTermDepartures
	 */
	public HashMap<Integer, Integer> getShortTermDepartures() {
		return shortTermDepartures;
	}

	/**
	 * @param shortTermDepartures the shortTermDepartures to set
	 */
	public void setShortTermDepartures(HashMap<Integer, Integer> shortTermDepartures) {
		this.shortTermDepartures = shortTermDepartures;
	}


	/**
	 * @return the shortTermArrivals
	 */
	public HashMap<Integer, Integer> getShortTermArrivals() {
		return shortTermArrivals;
	}


	/**
	 * @param shortTermArrivals the shortTermArrivals to set
	 */
	public void setShortTermArrivals(HashMap<Integer, Integer> shortTermArrivals) {
		this.shortTermArrivals = shortTermArrivals;
	}

}

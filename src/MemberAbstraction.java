

public abstract class MemberAbstraction {
	
	private Payment payment;
	
	/**
	 * Abstract methods for MemberStatus (State Pattern)
	 */
	/**
	 * Abstract methods for Payments (Bridge Pattern)
	 */
	abstract public boolean payDriver(float amt, boolean payType);
	abstract public void addPoints(float amt);

	/**
	 * Abstract methods for MemberSchedule
	 */
	
	public abstract void addArrivals(int day, int time);
	public abstract void addDepartures(int day, int time);
}
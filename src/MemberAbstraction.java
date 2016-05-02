import java.time.DayOfWeek;
import java.util.HashMap;

public abstract class MemberAbstraction {
	
	/**
	 * Abstract methods for MemberStatus (State Pattern)
	 */
	public abstract void setPassenger();
	public abstract void setDriver();
	
	public abstract MemberStatus getMemberStatus();
	public abstract void setMemberStatus(MemberStatus ms);
	
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
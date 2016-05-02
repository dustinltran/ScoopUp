
import java.util.HashMap;

public abstract class MemberSchedule implements java.io.Serializable {
	
	public abstract void addArrivals(int day, int time);
	public abstract void addDepartures(int day, int time);

}

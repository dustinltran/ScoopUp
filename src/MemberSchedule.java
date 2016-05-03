
import java.util.HashMap;

public abstract class MemberSchedule implements java.io.Serializable {
	
	public abstract void addArrivals(int day, String time);
	public abstract void addDepartures(int day, String time);

}

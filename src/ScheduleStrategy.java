import java.util.ArrayList;

public abstract class ScheduleStrategy {
	
	public abstract void createSchedule(Member driver, ArrayList<Member> passenger);
}

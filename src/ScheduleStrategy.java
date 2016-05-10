import java.io.IOException;
import java.util.ArrayList;

public abstract class ScheduleStrategy {
	
	public abstract Integer createSchedule(Member driver, ArrayList<Member> passenger, int day);
	public abstract String leaveTime(Member driver, ArrayList<Member> passenger, String arrive) throws IOException;
}

import java.io.IOException;
import java.util.ArrayList;

public class LongTermSchedule extends ScheduleStrategy{


	@Override
	public Integer createSchedule(Member driver, ArrayList<Member> passenger, int day) {
		// TODO Auto-generated method stub
		int schoolTime = Integer.parseInt(driver.getArrivalTimes(day));
		
		for(Member p: passenger){
			if(schoolTime > Integer.parseInt(p.getArrivalTimes(day)))
				schoolTime = Integer.parseInt(p.getArrivalTimes(day));
		}
		return schoolTime;
	}
	
	public String leaveTime(Member driver, ArrayList<Member> passenger, String arrive) throws IOException{

		Double hours = Double.parseDouble(arrive.substring(0, 2));
		Double minutes = Double.parseDouble(arrive.substring(3)) / 60;
		
		Double timeAsDec = hours + minutes;
		
		FindLocation fl = new FindLocation();
		String location = driver.getCoordinates();
		Double time = 0.0;
		for(Member m: passenger){
			fl.findDistanceTime(location, m.getCoordinates());
			time += fl.getTime();
		}
		time = timeAsDec - time;

		time = Math.floor(time * 100)/100;
		
		return time.toString();
	}
	

}

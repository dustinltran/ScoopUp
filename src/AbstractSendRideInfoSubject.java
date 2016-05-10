import java.util.ArrayList;
import java.util.Iterator;

//o
public abstract class AbstractSendRideInfoSubject {
	
	 
	private ArrayList<Member> members = new ArrayList<Member>();
	
	public AbstractSendRideInfoSubject(){
		
	}
	
	public void addMemberAsObserver(Member member){
		members.add(member);
	}
	
	public void deleteObserver(Member member){
		members.remove(member);
	}
	
	public void notifyMembers(String trackRideState){
		Iterator i = members.iterator();
		while(i.hasNext()){
			Member member = (Member)i.next();
			member.updateRideStateStatus(trackRideState);
		}
	}
}

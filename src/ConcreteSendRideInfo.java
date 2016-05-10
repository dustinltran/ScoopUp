import java.util.Iterator;

public class ConcreteSendRideInfo extends AbstractSendRideInfoSubject {
	public String memberRideState; 
	//can add parking info here
	
	public ConcreteSendRideInfo(String memberRideState){
		this.memberRideState = memberRideState; 
	}	
	
	public String getRideStatus(){
		return this.memberRideState;
	}
	
	public void setRideStatus(String memberRideState){
		this.memberRideState = memberRideState;
		//notify observers here
		notifyMembers(memberRideState);
	}
}

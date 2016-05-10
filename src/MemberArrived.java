
public class MemberArrived extends MemberStatus{
	private TrackRideAbstraction status;
	
	public MemberArrived(TrackRideAbstraction status){
		this.status = status;
	}

	@Override
	public String displayStatus() {
		// TODO Auto-generated method stub
		return "Member has Arrived";
	}

	@Override
	public String changeStatus()  {
		// TODO Auto-generated method stub
		status.setStatus(new MemberWaiting(status));
		
		return "Member is waiting to get connected";
	}

}

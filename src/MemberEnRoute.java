
public class MemberEnRoute extends MemberStatus{
	private TrackRideAbstraction status;
	
	public MemberEnRoute(TrackRideAbstraction status){
		this.status = status;
	}

	@Override
	public String displayStatus() {
		// TODO Auto-generated method stub
		return "Member is enroute";
	}

	@Override
	public String changeStatus()  {
		// TODO Auto-generated method stub
		status.setStatus(new MemberArrived(status));
		
		return "Member has arrived";
		
	}

}

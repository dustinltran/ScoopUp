
public class MemberDeparted extends MemberStatus{
	private TrackRideAbstraction status;
	
	public MemberDeparted(TrackRideAbstraction status){
		this.status = status;
	}


	@Override
	public String displayStatus() {
		return "Member has departed";
	}


	@Override
	public String changeStatus() {
		// TODO Auto-generated method stub

		status.setStatus(new MemberEnRoute(status));
		
		return "Member is now enroute";
	}


}

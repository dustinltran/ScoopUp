
public class MemberWaiting extends MemberStatus{

	private TrackRideAbstraction status;
	
	public MemberWaiting(TrackRideAbstraction tra){
		status = tra;
	}

	@Override
	public String displayStatus() {
		// TODO Auto-generated method stub
		return "Member is waiting to get connected";
	}
	@Override
	public String changeStatus()  {
		// TODO Auto-generated method stub
		status.setStatus(new MemberDeparted(status));
		
		return "Member has now departed";
	}

}


public class TrackRide extends TrackRideAbstraction{


	public MemberStatus memberStatus;
	
	public TrackRide(){ //i = 0 , 1 , 2
		memberStatus = new MemberWaiting(this);
	}


	@Override
	public void setStatus(MemberStatus m) {
		// TODO Auto-generated method stub
		memberStatus = m;
	}
	@Override
	public MemberStatus getStatus() {
		// TODO Auto-generated method stub
		return memberStatus;
	}

	@Override
	public void displayStatus() {
		// TODO Auto-generated method stub
		System.out.println(memberStatus.displayStatus());
	}


	@Override
	public void changeStatus() {
		// TODO Auto-generated method stub
		System.out.println(memberStatus.changeStatus());
	}



}

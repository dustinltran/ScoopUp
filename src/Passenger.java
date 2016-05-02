

public class Passenger extends MemberStatus {

	private MemberAbstraction member;
	
	public Passenger(MemberAbstraction ma) {
		member = ma;
	}
	
	public String setPassenger() {
		member.setMemberStatus(new Passenger(member));
		return "Your status is set to a Passenger.";
	}
	
	public String setDriver() {
		return "";
	}

}

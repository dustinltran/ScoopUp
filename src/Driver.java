

public class Driver extends MemberStatus {
	
	private MemberAbstraction member;
	
	public Driver (MemberAbstraction ma) {
		member = ma;
	}
	
	public String setPassenger(){
		return "";
	}
	
	public String setDriver() {
		member.setMemberStatus(new Driver(member));
		return "Your status is set to a Driver.";
	}

}
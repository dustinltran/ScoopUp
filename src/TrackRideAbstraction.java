
public abstract class TrackRideAbstraction {

	public abstract void depart();
	public abstract void enRoute();
	public abstract void arrived();
	
	public abstract MemberStatus getStatus();
	public abstract void setStatus(MemberStatus m);
	
}

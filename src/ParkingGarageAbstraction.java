
public abstract class ParkingGarageAbstraction {

	public abstract void assignParking();
	public abstract void checkIn();
	public abstract void checkOut();
//	public abstract void ticket();
	
	public abstract ParkingState getParkingState();
	public abstract void setParkingState(ParkingState ps);
	
	public abstract void setSpacesAvailable(int spacesAvailable);
	public abstract int getSpacesAvailable();
	
	public abstract void setSpacesUnavailable(int spacesUnavailable);
	public abstract int getSpacesUnavailable();
}


public class Unavailable extends ParkingState {
	
	private ParkingGarageAbstraction parking;
	
	public Unavailable(ParkingGarageAbstraction pga) {
		parking = pga;
	}

	@Override
	public String assignParking() {
		return "Parking is currently unavailable. Please wait...";
	}

	@Override
	public String checkIn() {
		return "Parking is currently unavailable. Please wait...";
		
	}

	@Override
	public String checkOut() {
		parking.setParkingState(new Available(parking));
		return "Parking space became available.";
		
	}
	
}
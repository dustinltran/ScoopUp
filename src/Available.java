
public class Available extends ParkingState{

	private ParkingGarageAbstraction parking;

	
	public Available(ParkingGarageAbstraction pga) {
		parking = pga;
	}

	@Override
	public String assignParking() {
		return "Your parking space number is: "+ parking.getSpacesAvailable() ;
	}

	@Override
	public String checkIn() {
		//start time
		parking.setParkingState(new Unavailable(parking));
		return "You are checked into space " + parking.getSpacesAvailable();
	}

	@Override
	public String checkOut() {
		// end time 
		// check if the time did not go over by x minutes
		// assign a penalty if it did
		parking.setParkingState(new Available(parking));
		return "You exited the garage. Sayonara!";
	}
	
}

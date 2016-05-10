
public class ParkingGarage extends ParkingGarageAbstraction{

	ParkingState state;
	
	private int spacesAvailable;
	private int spacesUnavailable;
	
	public ParkingGarage(int spacesAvailable, int spacesUnavailable){
		state = new Available(this);
		this.spacesAvailable = spacesAvailable;
		this.setSpacesUnavailable(spacesUnavailable);
	}
	
	@Override
	public void assignParking() {
		if (spacesAvailable == 0) {
			System.out.println("There are currently no spaces available.");
		}
		setSpacesAvailable(getSpacesAvailable() - 1);
		setSpacesUnavailable(getSpacesUnavailable() + 1);
		System.out.println(state.assignParking());
	}

	@Override
	public void checkIn() {
		System.out.println(state.checkIn());
	}

	@Override
	public void checkOut() {
		setSpacesAvailable(getSpacesAvailable() + 1);
		setSpacesUnavailable(getSpacesUnavailable() - 1);
		System.out.println(state.checkOut());
		
	}

	@Override
	public ParkingState getParkingState() {
		
		return state;
	}

	@Override
	public void setParkingState(ParkingState ps) {
		state = ps;
		
	}

	/**
	 * @return the spacesUnavailable
	 */
	public int getSpacesUnavailable() {
		return spacesUnavailable;
	}

	/**
	 * @param spacesUnavailable the spacesUnavailable to set
	 */
	public void setSpacesUnavailable(int spacesUnavailable) {
		this.spacesUnavailable = spacesUnavailable;
	}
	
	/**
	 * @return the spacesAvailable
	 */
	public int getSpacesAvailable() {
		return spacesAvailable;
	}

	/**
	 * @param spacesAvailable the spacesAvailable to set
	 */
	public void setSpacesAvailable(int spacesAvailable) {
		this.spacesAvailable = spacesAvailable;
	}
	
}

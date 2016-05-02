
public class Vehicle {
	private int year;
	private String make;
	private String model;
	private String color;
	private int availableSeats;
	
	/**
	 * EMPTY CONSTRUCTOR for testing
	 */
	public Vehicle(){
		
	}
	/**
	 * @param year
	 * @param make
	 * @param model
	 * @param color
	 * @param availableSeats
	 */
	 public Vehicle(int year, String make, String model, String color, int availableSeats) {
		//super();
		this.year = year;
		this.make = make;
		this.model = model;
		this.color = color;
		this.availableSeats = availableSeats;
	}
	
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}
	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @return the availableSeats
	 */
	public int getAvailableSeats() {
		return availableSeats;
	}
	/**
	 * @param availableSeats the availableSeats to set
	 */
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	
}

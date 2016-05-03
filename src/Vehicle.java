
public class Vehicle implements java.io.Serializable{
	private String year;
	private String make;
	private String model;
	private String color;
	private String availableSeats;
	
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
	 public Vehicle(String year, String make, String model, String color, String availableSeats) {
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
	public String getYear() {
		return year;
	}
	/**
	 * @param string the year to set
	 */
	public void setYear(String string) {
		this.year = string;
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
	public String getAvailableSeats() {
		return availableSeats;
	}
	/**
	 * @param availableSeats the availableSeats to set
	 */
	public void setAvailableSeats(String availableSeats) {
		this.availableSeats = availableSeats;
	}
	
}

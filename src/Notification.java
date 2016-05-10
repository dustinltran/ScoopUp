public class Notification {
	private String type; 
	private String text;
	
	public Notification(String notificationType, String notificationText){
		this.type = notificationType; 
		this.text = notificationText; 
	}
	
	public String getNotificationText(){
		return this.text;
	}
	
	public String getNotificationType(){
		return this.type;
	}
	
	public void setNotificationText(){
		this.text = text;
	}
	
	public void setNotificationType(){
		this.type = type;
	}
}

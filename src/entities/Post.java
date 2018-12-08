package entities;

public class Post {
	
	private int id; 
	private String sender;
	private String receiver;
	private String message;
	
	
	public Post() {
		
	}
	
	
	
	public Post(int id, String sender, String receiver, String message) {
		super();
		this.id = id;
		this.sender = sender;
		this.receiver = receiver;
		this.message = message;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}

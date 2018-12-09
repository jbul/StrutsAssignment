package entities;

public class Post {
	
	private int id; 
	private Person sender;
	private Person receiver;
	private String message;
	
	
	public Post() {
		sender = new Person();
		receiver = new Person();
	}
	
	
	public Post(int id, Person sender, Person receiver, String message) {
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
	public Person getSender() {
		return sender;
	}
	public void setSender(Person sender) {
		this.sender = sender;
	}
	public Person getReceiver() {
		return receiver;
	}
	public void setReceiver(Person receiver) {
		this.receiver = receiver;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}

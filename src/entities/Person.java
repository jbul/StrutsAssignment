package entities;

public class Person {
	private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String gender;
	
    public Person() {}
    
    public Person(String firstname, String lastname, String email, String password, String gender) {
    	setFirstName(firstname);
    	setLastName(lastname);
    	setEmail(email);
    	setPassword(password);
    	setGender(gender);
    }
    
    public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "FirstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", gender=" + gender;
	}
    
}

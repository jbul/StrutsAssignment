package entities;

import java.util.List;

public class Person {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String gender;

	private List<Person> friends;
	private List<Post> wall;

	public Person() {
	}

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

	public List<Person> getFriends() {
		return friends;
	}

	public void setFriends(List<Person> friends) {
		this.friends = friends;
	}

	public List<Post> getWall() {
		return wall;
	}

	public void setWall(List<Post> wall) {
		this.wall = wall;
	}

	@Override
	public String toString() {
		return "FirstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password
				+ ", gender=" + gender;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean result = true;
		if (o != null) {
			Person p = (Person) o;
			if (!this.getEmail().equalsIgnoreCase(p.getEmail())) {
				result = false;
			}
		}
		return result;
	}
}

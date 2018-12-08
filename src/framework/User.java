package framework;

import com.opensymphony.xwork2.ActionSupport;

public class User{
	private String firstname, loggedin;
	
	public User() {
		
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLoggedin() {
		return loggedin;
	}

	public void setLoggedin(String loggedin) {
		this.loggedin = loggedin;
	}
	
	public String createUser() {
		if(this.firstname.equalsIgnoreCase("Julie")) {
			this.loggedin = "Me";
			return "SUCCESS";
		}
		else {
			this.loggedin = "Guest";
			return "FAILURE";
			
		}
	}
	
	
}

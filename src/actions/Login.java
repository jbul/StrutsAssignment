package actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import dao.BaseDAO;
import entities.Person;

public class Login implements SessionAware {
	private Person person; 
	Map<String, Object> sessionmap; 
	BaseDAO dao;
	
	public Login() {
		dao = new BaseDAO();
	}
	
	@Override
	public void setSession(Map map) {
		this.sessionmap = (Map<String, Object>) map;
	}
	
	public String login() {
		//check if logged in 
		Person p = dao.login(person.getEmail(), person.getPassword());
		if(p != null) {
			this.sessionmap.put("loggedUser", p);
			person = p;
			return "USER";
		}
		else {
			return "FAILURE";
		}
	}
	
	public String logout(){
		sessionmap.clear();
		return "SUCCESS";
	}
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	

}

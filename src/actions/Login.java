package actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.BaseDAO;
import entities.Person;

public class Login extends ActionSupport {
	private Person person;
	BaseDAO dao;

	public Login() {
		dao = new BaseDAO();
	}
	
	
	public String login() {
		Map<String, Object> sessionmap = ActionContext.getContext().getSession(); 
		//check if logged in 
		Person p = dao.login(person.getEmail(), person.getPassword());
		if(p != null) {
			sessionmap.put("loggedUser", p);
//			person = p;
			return "USER";
		}
		else {
			return "FAILURE";
		}
	}
	
	public String logout(){
		Map<String, Object> sessionmap = ActionContext.getContext().getSession(); 
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

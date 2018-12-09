package actions;

import java.util.Map;

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
		Person p = null;
		// check if logged in
		if (sessionmap.containsKey("loggedUser")) {
			p = (Person) sessionmap.get("loggedUser");
		} else {
			p = dao.login(person.getEmail(), person.getPassword());
		}
		if (p != null) {
			p.setFriends(dao.getUserFriends(p.getEmail()));
			p.setWall(dao.getUserPost(p.getEmail()));
			sessionmap.put("loggedUser", p);
			return "USER";
		}
		return "FAILURE";
	}

	public String logout() {
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

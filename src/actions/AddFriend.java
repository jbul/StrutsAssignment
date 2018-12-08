package actions;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import dao.BaseDAO;
import entities.Person;

public class AddFriend {
	
	private BaseDAO dao;
	
	public AddFriend() {
		this.dao = new BaseDAO();
	}
	
	public String add() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		Person connectedUser = (Person) session.get("loggedUser");
		Person friend = (Person) session.get("personView");
		dao.addFriend(connectedUser.getEmail(), friend.getEmail());
		return "SUCCESS";
	}
	
	
}

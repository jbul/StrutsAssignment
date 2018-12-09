package actions;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import dao.BaseDAO;
import entities.Person;

public class ViewUser {
	
	private String email;
	private boolean isFriend;
	private BaseDAO dao;
	
	public ViewUser() {
		dao = new BaseDAO();
		isFriend = false;
	}
	
	public String view() {
		Person person = null;
		Map<String, Object> session = ActionContext.getContext().getSession();
		
		if (email != null && email != "") {
			person = dao.getUserEmail(email);
		} else if (session.get("personView") != null) {
			person = (Person) session.get("personView");
		}
		
		if (person != null) {
			person.setFriends(dao.getUserFriends(person.getEmail()));
			person.setWall(dao.getUserPost(person.getEmail()));
			
			if (person.getFriends().contains(session.get("loggedUser"))) {
				isFriend = true;
			}else {
				isFriend = false;
			}
			
			session.put("personView", person);
			return "SUCCESS";
		}
		
		return "SUCCESS";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getIsFriend() {
		return isFriend;
	}

	public void setIsFriend(boolean isFriend) {
		this.isFriend = isFriend;
	}
	
	

}

package actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.BaseDAO;
import entities.Person;

public class SearchUsers extends ActionSupport{
	BaseDAO baseDao;
	List<Person> pers;
	String searchField;
	
	public String getSearchField() {
		return searchField;
	}
	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}
	public SearchUsers() {
		this.baseDao = new BaseDAO();
	}
	public List<Person> getPers() {
		return pers;
	}
	public void setPers(List<Person> pers) {
		this.pers = pers;
	}
	
	public String search() {
		pers = this.baseDao.searchUsers(searchField);
		return "SUCCESS";
	}
	
	public String display() {
		pers = this.baseDao.displayAllUsers();
		return "SUCCESS";
	}
	
	
}

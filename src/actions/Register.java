package actions;

import com.opensymphony.xwork2.ActionSupport;

import dao.BaseDAO;
import entities.Person;

public class Register extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Person person;
	BaseDAO baseDao;

	public Register() {
		this.baseDao = new BaseDAO();
	}

	public String execute() {
		if (!(person.getFirstName().isEmpty() || person.getLastName().isEmpty() || person.getEmail().isEmpty()
				|| person.getEmail().isEmpty() || person.getGender().isEmpty())) {
			this.baseDao.saveData(person);
			return "SUCCESS";
		} else
			return "FAILURE";
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}

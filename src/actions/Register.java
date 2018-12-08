package actions;

import com.opensymphony.xwork2.ActionSupport;

import dao.BaseDAO;
import entities.Person;

public class Register extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Person person;
	BaseDAO baseDao;
	private String returnMessage;

	public Register() {
		this.baseDao = new BaseDAO();
	}

	public String execute() {
		if (!(person.getFirstName().isEmpty() || person.getLastName().isEmpty() || person.getEmail().isEmpty()
				|| person.getEmail().isEmpty() || person.getGender().isEmpty())) {
			if (!this.baseDao.checkEmail(person.getEmail())) {
				this.baseDao.saveData(person);
				return "SUCCESS";
			} else {

				setReturnMessage("User already exists");
			}
		} else {

			setReturnMessage("Please, fill all fields");
		}
		return "FAILURE";
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}

}

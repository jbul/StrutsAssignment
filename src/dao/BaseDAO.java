package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import entities.Person;

public class BaseDAO {

	private Connection connection;

	public BaseDAO() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dt354jdbc?user=root&password=root");
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveData(Person p) {

		try {
			PreparedStatement ps = connection.prepareStatement("insert into users values(?,?,?,?,?)");
			ps.setString(1, p.getFirstName());
			ps.setString(2, p.getLastName());
			ps.setString(3, p.getEmail());
			ps.setString(4, p.getPassword());
			ps.setString(5, p.getGender());

			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Person login(String email, String userpass) {
		Person p = null;
		boolean status;
		try {
			PreparedStatement ps = connection.prepareStatement("select * from users where email=? and passw=?");
			ps.setString(1, email);
			ps.setString(2, userpass);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			if (status) {
				p = new Person(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return p;
	}

	public boolean checkEmail(String email) {
		boolean result = false;
		try {
			PreparedStatement ps = connection.prepareStatement("select * from users where email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			result = rs.next();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Person> searchUsers(String search) {
		List<Person> person = new ArrayList<>();
		try {
			Statement select = connection.createStatement();
			ResultSet rs = select.executeQuery("SELECT * from users where firstName like '%" + search + "%' or lastName like '%" + search + "%'");
			
			Person p;
			while(rs.next()) {
				p = new Person(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				person.add(p);
			}	
			select.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return person;
	}
	
	public List<Person> displayAllUsers() {
		List<Person> person = new ArrayList<>();
		try {
			Statement select = connection.createStatement();
			ResultSet rs = select.executeQuery("SELECT * from users");
			
			Person p;
			while(rs.next()) {
				p = new Person(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				person.add(p);
			}	
			select.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return person;
	}
		

	
	public Person getUserEmail(String email) {
		
		PreparedStatement ps;
		Person p = null;
		boolean status = false;;
		try {
			ps = connection.prepareStatement("select * from users where email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			if (status) {
				p = new Person(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}	
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
}

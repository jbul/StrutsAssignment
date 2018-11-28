package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			PreparedStatement ps=connection.prepareStatement("insert into users values(?,?,?,?,?)");  
			ps.setString(1,p.getFirstName());  
			ps.setString(2,p.getLastName());  
			ps.setString(3,p.getEmail());  
			ps.setString(4,p.getPassword());
			ps.setString(5,p.getGender());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Person login(String username, String userpass) {
		Person p = null;
		boolean status;
		try {
			PreparedStatement ps = connection.prepareStatement("select * from users where email=? and passw=?");
			ps.setString(1, username);
			ps.setString(2, userpass);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			if (status) {
				p = new Person(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return p;
	}
}

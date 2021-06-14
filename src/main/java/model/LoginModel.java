package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import entity.Login;

public class LoginModel {

	/*public List<Login> listUsers(DataSource dataSource) {
		// Step 1: Initialize connection objects
		List<Login> listUsers = new ArrayList<>(); 
        Connection connect = null;
        Statement stmt = null;
        ResultSet rs = null;       
        try {
			connect = dataSource.getConnection();			
			// Step 2: Create a SQL statements string
			String query = "Select * from users";
			stmt = connect.createStatement();
			// Step 3: Execute SQL query
         rs = stmt.executeQuery(query);
			// Step 4: Process the result set
			while(rs.next()){
				listUsers.add(new Login(rs.getInt("users_id"), rs.getString("username"), rs.getString("email")));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return listUsers;
	}*/

	public String addUser(DataSource dataSource, Login newUser) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			
			connect = dataSource.getConnection();
			String name = newUser.getName();
			String email = newUser.getEmail();
			String password = newUser.getPassword();
			String type = newUser.getType();
			
			String query = "insert into login (name,email,password,type) values (?,?,?,?)";
			statement = connect.prepareStatement(query);
			statement.setString(1, name);
			statement.setString(2, email);
			statement.setString(3, password);
			statement.setString(4, type);
			statement.execute();
			System.out.print(query+" "+name+" "+email+" "+password+" "+type);
			return "normal";
			
		} catch (SQLException e) {
			e.printStackTrace();
			return "abnormal";
		}
	}
	//modify this
	public Login loginUser(DataSource dataSource, Login newUser) {
		Connection connect = null;
		PreparedStatement statement = null;
		ResultSet rs = null; 
		try {
			
			connect = dataSource.getConnection();
			//String name = newUser.getName();
			String email = newUser.getEmail();
			String password = newUser.getPassword();
			//String type = newUser.getType();
			
			String query = "select * from login where email=?";
			statement = connect.prepareStatement(query);
			//statement.setString(1, name);
			statement.setString(1, email);
			rs=statement.executeQuery();
			rs.next();
			//System.out.println(rs.getString("password")+" "+password);
			if(rs.getString("password").equals(password) && rs.getString("type").equals("user"))
			{
				return new Login(rs.getString("name"), rs.getString("email"), rs.getString("type"));
			}
			else if(rs.getString("password").equals(password) && rs.getString("type").equals("org"))
			{
				return new Login(rs.getString("name"), rs.getString("email"), rs.getString("type"));
			}
			else
			{
				return null;
			}
			
			
			//statement.setString(4, type);
			
			//System.out.print(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}

	/*public void updateUser(DataSource dataSource, Login updatedUser) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			int usersId = updatedUser.getUsers_id();
			String username = updatedUser.getName();
			String email = updatedUser.getEmail();
			String query = "update users set username = ? , email = ? where users_Id = ? ";
			statement = connect.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, email);
			statement.setInt(3, usersId);
			statement.execute();		
		} catch (SQLException e) {
			e.printStackTrace();			
		}		
	}*/

	/*public void deleteUser(DataSource dataSource, int usersID) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			String query = "delete from users where users_Id = ? ";
			statement = connect.prepareStatement(query);
			statement.setInt(1, usersID);
			statement.execute();	
		} catch (SQLException e) {
			e.printStackTrace();			
		}		
	}
}*/








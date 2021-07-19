package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import entity.*;

public class ReqModel {

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

	public List<Requirements> viewReq(DataSource dataSource,Requirements req) {
		List<Requirements> lr=new ArrayList<>();
		Connection connect = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;    
        String name = req.getName();
		String email = req.getEmail();
		String type = req.getType();
        try {
			connect = dataSource.getConnection();			
			
			String query = "Select * from requirements where ogname=? and ogemail=?";
			stmt = connect.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setString(2, email);
			
			
            rs = stmt.executeQuery();
			
			while(rs.next()){
				//System.out.println(rs.getString("name")+ rs.getString("email")+rs.getString("type")+rs.getString("rtype")+rs.getString("comment")+rs.getString("status"));
				lr.add(new Requirements(rs.getString("name"),rs.getString("rtype"),rs.getString("ogname"),rs.getString("status")));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return lr;
		
	}
	public List<Requirements> acceptReq(DataSource dataSource,Requirements req) {
		List<Requirements> lr=new ArrayList<>();
		Connection connect = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;    
        String name = req.getName();
		String email = req.getEmail();
		String type = req.getType();
        try {
			connect = dataSource.getConnection();			
			
			String query = "Select * from requirements where status='open'";
			stmt = connect.prepareStatement(query);			
            rs = stmt.executeQuery();
			
			while(rs.next()){
				//System.out.println(rs.getString("name")+ rs.getString("email")+rs.getString("type")+rs.getString("rtype")+rs.getString("comment")+rs.getString("status"));
				lr.add(new Requirements(rs.getString("name"),rs.getString("email"),rs.getString("type"),rs.getString("rtype"),rs.getString("comment"),rs.getString("ogname"),rs.getString("ogemail"),rs.getString("status")));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return lr;
		
	}
	public List<Requirements> listReq(DataSource dataSource,Requirements req) {
		List<Requirements> lr=new ArrayList<>();
		Connection connect = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;    
        String name = req.getName();
		String email = req.getEmail();
		String type = req.getType();
        try {
			connect = dataSource.getConnection();			
			
			String query = "Select * from requirements where name=? and email=? and type=?";
			stmt = connect.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setString(3, type);
			
            rs = stmt.executeQuery();
			
			while(rs.next()){
				//System.out.println(rs.getString("name")+ rs.getString("email")+rs.getString("type")+rs.getString("rtype")+rs.getString("comment")+rs.getString("status"));
				lr.add(new Requirements(rs.getString("name"),rs.getString("rtype"),rs.getString("ogname"),rs.getString("status")));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return lr;
		
	}
	public String addReq(DataSource dataSource, Requirements newUser) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			//System.out.println("came here");
			connect = dataSource.getConnection();
			String name = newUser.getName();
			String email = newUser.getEmail();
			String type = newUser.getType();
			String rtype = newUser.getRtype();
			String comment = newUser.getComment();
			//System.out.print(" "+name+" "+email+" "+type+" "+rtype+" "+comment);
			String query = "insert into requirements (name,email,type,rtype,comment) values (?,?,?,?,?)";
			statement = connect.prepareStatement(query);
			statement.setString(1, name);
			statement.setString(2, email);
			statement.setString(3, type);
			statement.setString(4, rtype);
			statement.setString(5, comment);
			statement.execute();
			//System.out.print(query+" "+name+" "+email+" "+type+" "+rtype+" "+comment);
			return "normal";
			
		} catch (SQLException e) {
			e.printStackTrace();
			return "abnormal";
		}
	}
	public String updateReq(DataSource dataSource, Requirements newUser) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			//System.out.println("came here");
			connect = dataSource.getConnection();
			String name = newUser.getName();
			String email = newUser.getEmail();
			String type = newUser.getType();
			String rtype = newUser.getRtype();
			String ogname = newUser.getOgname();
			String ogemail = newUser.getOgemail();
			//System.out.print(" "+name+" "+email+" "+type+" "+rtype+" "+ogname+" "+ogemail);
			String query = "update requirements set ogname=?, ogemail=?, status=? where email=? and rtype=?";
			statement = connect.prepareStatement(query);
			statement.setString(1, ogname);
			statement.setString(2, ogemail);
			statement.setString(3, "closed");
			statement.setString(4, email);
			statement.setString(5, rtype);
			statement.execute();
			//System.out.print(query+" "+name+" "+email+" "+type+" "+rtype+" ");
			return "normal";
			
		} catch (SQLException e) {
			e.printStackTrace();
			return "abnormal";
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




package com.cg.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.List;
import java.util.Properties;

import com.cg.bean.LoginBean;
import com.cg.bean.SearchBean;
import com.cg.bean.UserBean;
import com.cg.exception.InvalidUserException;
import com.cg.exception.UserNotFoundException;
import com.cg.exception.UserNotRegisteredException;

public class SearchDaoImpl implements SearchDao {

	@Override
	public UserBean authenticate(LoginBean login) throws InvalidUserException{
		int rows=0;
		Connection conn = null;
		UserBean user = null;
		Decoder decoder = Base64.getDecoder();
		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(authenticateQuery);
			stmt.setString(1, login.getUserid());
			stmt.setString(2, login.getPassword());
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				user = new UserBean();
				user.setUserid(rs.getString(1));
				//String decodedPassword = new String(decoder.decode(rs.getString(2).getBytes()));
				user.setPassword(rs.getString(2));
				user.setName(rs.getString(3));
				user.setAge(rs.getInt(4));
				user.setGender(rs.getString(5));
				user.setCity(rs.getString(6));
				user.setEmail(rs.getString(7));
			}
			return user;
		} catch (SQLException e) {
			throw new InvalidUserException(e);
		}
	}
	
	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getMessage());
		}
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Vishal", "oracle");
		return conn;
	}

	@Override
	public Boolean persist(UserBean user) throws UserNotRegisteredException{
		Connection conn = null;
		int rows = 0;
		try {
			conn = getConnection();
			
			PreparedStatement stmt = conn.prepareStatement(insertQuery);
			stmt.setString(1, user.getUserid());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getName());
			stmt.setInt(4, user.getAge());
			stmt.setString(5, user.getGender());
			stmt.setString(6, user.getCity());
			stmt.setString(7, user.getEmail());
			
			rows = stmt.executeUpdate();
			System.out.println(rows);
		} catch (SQLException e) {
			throw new UserNotRegisteredException(e);
		}
		
		if(rows==0)
			return false;
		else
			return true;
	}

	@Override
	public List<UserBean> search(SearchBean search) throws UserNotFoundException {
		Connection conn = null;
		UserBean user = new UserBean();
		Decoder decoder = Base64.getDecoder();
		List<UserBean> users = new ArrayList<UserBean>();
		//String decodedPassword = null;
		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(getQuery);
			stmt.setInt(1,search.getAgeFrom());
			stmt.setInt(2, search.getAgeTo());
			stmt.setString(3, search.getGender());
			stmt.setString(4, search.getCity());
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				user = new UserBean();
				user.setUserid(rs.getString(1));
				//String decodedPassword = new String(decoder.decode(rs.getString(2).getBytes()));
				user.setPassword(rs.getString(2));
				user.setName(rs.getString(3));
				user.setAge(rs.getInt(4));
				user.setGender(rs.getString(5));
				user.setCity(rs.getString(6));
				user.setEmail(rs.getString(7));
				System.out.println("While ke andar " + user.getName());
				users.add(user);
			}
			System.out.println("lenfhttrgjdg" + users.size());
			return users;
		} catch (SQLException e) {
			throw new UserNotFoundException(e);
		}
		
	}

}

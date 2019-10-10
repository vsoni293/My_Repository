package com.cg.dao;

import java.util.List;

import com.cg.bean.LoginBean;
import com.cg.bean.SearchBean;
import com.cg.bean.UserBean;
import com.cg.exception.InvalidUserException;
import com.cg.exception.UserNotFoundException;
import com.cg.exception.UserNotRegisteredException;

public interface SearchDao {
	
	String insertQuery = "insert into users values(?,?,?,?,?,?,?)";
	String authenticateQuery = "select * from users where userid=? and password=?";
	String getQuery = "select* from users where (age between ? and ?)AND(gender LIKE ?)AND(city LIKE ?)";
	
	UserBean authenticate(LoginBean login) throws InvalidUserException;
	Boolean persist(UserBean user) throws UserNotRegisteredException;
	List<UserBean> search(SearchBean search) throws UserNotFoundException;
}

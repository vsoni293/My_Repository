package com.cg.service;

import java.util.List;

import com.cg.bean.LoginBean;
import com.cg.bean.SearchBean;
import com.cg.bean.UserBean;
import com.cg.exception.InvalidUserException;
import com.cg.exception.UserNotFoundException;
import com.cg.exception.UserNotRegisteredException;

public interface SearchService {
	
	UserBean validate(LoginBean login) throws InvalidUserException;
	Boolean save(UserBean user) throws UserNotRegisteredException;
	List<UserBean> search(SearchBean search) throws UserNotFoundException;
}

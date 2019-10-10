package com.cg.service;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.List;

import com.cg.bean.LoginBean;
import com.cg.bean.SearchBean;
import com.cg.bean.UserBean;
import com.cg.dao.SearchDao;
import com.cg.dao.SearchDaoImpl;
import com.cg.exception.InvalidUserException;
import com.cg.exception.UserNotFoundException;
import com.cg.exception.UserNotRegisteredException;

public class SearchServiceImpl implements SearchService{
	
	SearchDao dao = new SearchDaoImpl();
	@Override
	public UserBean validate(LoginBean login) throws InvalidUserException {
		Encoder encoder = Base64.getEncoder();
		System.out.println("Original password : " + login.getPassword());
		String encodedPassword = new String(encoder.encodeToString(login.getPassword().getBytes()));
		login.setPassword(encodedPassword);
		System.out.println("Encoded password: " + login.getPassword());
		return dao.authenticate(login);
	}

	@Override
	public Boolean save(UserBean user) throws UserNotRegisteredException {
//		Encoder encoder = Base64.getEncoder();
//		String encodedPassword = encoder.encodeToString(user.getPassword().getBytes());
//		user.setPassword((String)encodedPassword);
		return dao.persist(user);
	}

	@Override
	public List<UserBean> search(SearchBean search) throws UserNotFoundException {	
		return dao.search(search);
	}
	
}

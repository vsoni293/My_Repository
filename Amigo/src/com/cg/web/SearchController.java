package com.cg.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.bean.SearchBean;
import com.cg.bean.UserBean;
import com.cg.exception.UserNotFoundException;
import com.cg.service.SearchService;
import com.cg.service.SearchServiceImpl;

/**
 * Servlet implementation class SearchController
 */
@WebServlet(name = "Search", urlPatterns = { "/Search.do" })
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SearchService service;
	
	

	@Override
	public void init() throws ServletException {
		service = new SearchServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		SearchBean search = new SearchBean();
		if(request.getParameter("ageFrom")!=null)
			search.setAgeFrom(Integer.parseInt(request.getParameter("ageFrom")));
		if(request.getParameter("ageTo")!=null)
			search.setAgeTo(Integer.parseInt(request.getParameter("ageTo")));
		if(request.getParameter("gender")!=null)
			search.setGender(request.getParameter("gender"));
		if(request.getParameter("city")!=null)
			search.setCity(request.getParameter("city"));
		
		System.out.println("Controller ke andar : " + search.getGender());
		List<UserBean> users = new ArrayList<UserBean>();
		try {
			users = service.search(search);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("USERS", users);
		getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

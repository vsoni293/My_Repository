package com.cg.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.bean.LoginBean;
import com.cg.bean.UserBean;
import com.cg.exception.InvalidUserException;
import com.cg.exception.UserNotRegisteredException;
import com.cg.service.SearchService;
import com.cg.service.SearchServiceImpl;

/**
 * Servlet implementation class UserController
 */
@WebServlet(name = "User", urlPatterns = { "/User.do" })
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SearchService service;
	
	@Override
	public void init() throws ServletException {
		service = new SearchServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String referer = request.getHeader("referer");
		if(referer.contains("home")){
			//request came from home page
			LoginBean login  = new LoginBean();
			//Reading request params and setting into bean
			login.setUserid(request.getParameter("userid"));
			login.setPassword(request.getParameter("password"));
			System.out.println("Login inside user control : " + login.getUserid());
			UserBean user = null; 
			try {
				user = service.validate(login);
			} catch (InvalidUserException e) {
				System.out.println(e.getMessage());
			}
			if(user!=null){
				//Login successful..show search page
				HttpSession session = request.getSession();
				
				session.setAttribute("USERS", user.getName());
				System.out.println("USER.getname(0_ :" + user.getName());
				response.sendRedirect("search.jsp");
				System.out.println("BCBCBCBC");
			}else{
				//Login failed..show home page
				System.out.println("Login failed!");
				response.sendRedirect("home.jsp?invalid=true");
			}
		}else{
			//request coming from registration page
			UserBean user = new UserBean();
			//Reading request params and setting into bean
			user.setUserid(request.getParameter("userid"));
			user.setPassword(request.getParameter("password"));
			user.setName(request.getParameter("name"));
			user.setGender(request.getParameter("gender"));
			user.setAge(Integer.parseInt(request.getParameter("age")));
			user.setCity(request.getParameter("city"));
			user.setEmail(request.getParameter("email"));
			
			try {
				if(service.save(user)){
					//user registered successfully
					response.sendRedirect("home.jsp");
				}else{
					//user registration failed..show register page
					response.sendRedirect("register.jsp");
				}
			} catch (UserNotRegisteredException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Delegate the request to doGet service method
		doGet(request,response);
	}

}

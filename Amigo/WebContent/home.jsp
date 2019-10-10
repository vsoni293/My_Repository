<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="banner.html" %>
	<% if(request.getParameter("invalid") !=null){ %>
	<font color="red">Invalid UserId/Password</font>
	<% } %>
	<% if(request.getParameter("logout")!=null){ 
		response.setHeader("Cache-Control","no-cache");
  		response.setHeader("Cache-Control","no-store");
  		response.setHeader("Pragma","no-cache");
  		response.setDateHeader ("Expires", 0);
		session.setAttribute("USERS",null);
		session.invalidate();
		//session.setAttribute("USERS", null);
		
		%>
		<font color="blue">Logged out successfully.</font>
		<% } %>
	<h3>Home</h3><br>
	<form action="User.do">
		<table>
			<tr>
				<td>Enter userId:</td>
				<td><input type="text" name="userid" id="userid" required
					pattern="[\w]+"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" id="password"
					required pattern="[\w]+"></td>
			</tr>
			<tr>
		    	<th><input type="submit" value="Login"></th>
		    </tr>
		</table>
	</form>
</body>
</html>
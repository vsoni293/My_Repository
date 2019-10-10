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
	<% String name = (String)session.getAttribute("USERS"); 
	if(name !=null){%>
	<p>Welcome <%= name %> | <a href="home.jsp?logout=yes">Logout</a></p>
	<% }else{ 
		response.sendRedirect("home.jsp");
	}%>
	
	<h3>Search</h3><br>
	<form action="Search.do">
		<table>
			<tr>
				<td>Age from:</td>
				<td><select name="ageFrom" id="ageFrom">
						<option disabled selected value>--Select age--</option>
						<% for(int a=18;a<=60;a++){ %>
						<option value="<%=a%>"><%=a%></option>
						<% } %>
				</select></td>
			</tr>
			<tr>
				<td>Age to:</td>
				<td><select name="ageTo" id="ageTo">
						<option disabled selected value>--Select age--</option>
						<% for(int a=18;a<=60;a++){ %>
						<option value="<%=a%>"><%=a%></option>
						<% } %>
				</select></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><input type="radio" id="gender" name="gender" value="m">Male
					<br> <input type="radio" id="gender" name="gender"
					value="f">Female <br> <input type="radio"
					id="gender" name="gender" value="o">Others <br></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><select name="city" id="city">
						<option disabled selected value>--Select a city--</option>
						<% String[] cities = {"Mumbai","Pune","Nagpur","Nashik","Goa"};
		            	for(String ct : cities){%>
						<option value="<%=ct%>"><%=ct%></option>
						<% } %>
				</select></td>
			</tr>
			<tr>
				<td>
					<button type="submit">Search</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
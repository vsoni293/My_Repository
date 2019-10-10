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
	<h3>Register</h3><br>
	<form action="User.do">
		<table>
		    <tr>
		        <td>Enter name: </td>
		        <td><input type="text" id="name" name="name"/></td>
		    </tr>
		    <tr>
		        <td>Age: </td>
		        <td><select name="age" id="age">
		            <option disabled selected value>--Select age--</option>
		            <% for(int a=18;a<=60;a++){ %>
		            	<option value="<%=a%>"><%=a%></option>
		            <% } %>  
		        </select></td>
		    </tr>
		    <tr>
		        <td>Gender: </td>
		        <td><input type="radio" id="gender" name="gender" value="m">Male <br>
		            <input type="radio" id="gender" name="gender" value="f">Female <br>
		            <input type="radio" id="gender" name="gender" value="o">Other <br>
		        </td> 
		    </tr>
		    <tr>
		        <td>City: </td>
		        <td><select name="city" id="city">
		            <option disabled selected value>--Select a city--</option>
		            <% String[] cities = {"Mumbai","Pune","Nagpur","Nashik","Goa"};
		            	for(String ct : cities){%>
		            <option value="<%=ct%>"><%=ct%></option>
		            <% } %>
		            </select>
		        </td>
		    </tr>
		    <tr>
		        <td>Enter userId: </td>
		        <td><input type="text" name="userid" id="userid" required pattern="[\w]+"></td>
		    </tr>
		    <tr>
		        <td>Password: </td>
		        <td><input type="password" name="password" id="password" required pattern="[\w]+"></td>
		    </tr>
		    <tr>
		        <td>Email: </td>
		        <td><input type="text" name="email" id="email" required></td>
		    </tr>
		    <tr>
		    	<td>
		    		<button type="submit">Register</button>
		    	</td>
		    </tr>
		</table>
	</form>
</body>
</html>
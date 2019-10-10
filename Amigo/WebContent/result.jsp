<%@page import="com.cg.bean.UserBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!--<script type="text/javascript">
	function destroy(){
		alert("DESTROYED!");
		var userName = null;
	    session.setAttribute("USERS",null);
	    alert(session.getAttribute("USERS"));
		window.location='/home.jsp?logout=yes';
	}
</script>-->
</head>
<body>
	<%@ include file="banner.html" %>
	<% String name = (String)session.getAttribute("USERS");
	if(name==null){
		response.sendRedirect("home.jsp");
		}else{%>
	<p>Welcome <%= name %> | <input type="button" onClick="destroy()" value="Logout"></p>
	<% }%>
	
	<h3>Result</h3><br>
	<% List<UserBean> users = (List) request.getAttribute("USERS"); %>
	<table>
	<% for(UserBean ub : users){ %>
		<tr>
			<td><%= ub.getName() %></td>
			<td><%= ub.getUserid() %></td>
			<td><%= ub.getPassword() %></td>
		</tr>
		<% } %>
	</table>
	<a href="search.jsp">Search again..</a>
</body>
</html>
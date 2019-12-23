<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page session="false" %>
	
	<%String msg=(String)request.getAttribute("msg"); %>
	
	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% if(msg != null && !msg.isEmpty()){  %>
<%=msg %>
<% }%>
	<fieldset>
		<legend>Employee Login</legend>
		<form action="./login2" method="post">
			<table>
				<tr>
					<td>Id</td>
					<td>:</td>
					<td><input type="number" name="empId" required>
				</tr>
				<tr>
					<td>Password</td>
					<td>:</td>
					<td><input type="password" name="password" required>
				</tr>

				<tr>
					<td colspan="3" align="center"><br> <input type="submit"
						value="Login"></td>
			</table>
		</form>
	</fieldset>
</body>
</html>
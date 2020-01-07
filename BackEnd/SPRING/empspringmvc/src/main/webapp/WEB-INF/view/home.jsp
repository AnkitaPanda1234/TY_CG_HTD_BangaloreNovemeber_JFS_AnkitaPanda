<%@page import="java.util.List"%>
<%@page import="com.cap.empspringmvc.bean.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="bean" class="com.cap.empspringmvc.bean.EmployeeBean"
	scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="./changepassword">Change Password</a>
	<a href="./logout" style="float: right;"> LogOut</a>



	<h1>
		Welcome <%=bean.getName()%></h1>
	<form action="./search">

		<table>
			<tr>
				<td>Enter Key :</td>
				<td><input type="text" name="key"></td>
				<td><input type="submit" value="search"></td>
			</tr>

		</table>

	</form>
	
	<%
	List<EmployeeBean>list=(List<EmployeeBean>)request.getAttribute("list");
	%>
	<%
	if(list!=null){
	
	%>
	<%if(list.isEmpty()) {%>
	<h3>No Data Found</h3>
	
	<%} else{%>
	<!-- To Task -->
	<table>
	<tr>
	<th>Id</th>
	<th>Name</th>
	<th>Email</th>
	</tr>
	
	
	<%for(EmployeeBean employee:list){ %>
	<tr>
	<td><%=employee.getId() %></td>
	<td><%=employee.getName() %></td>
	<td><%=employee.getEmail() %></td>
	</tr>
	<%} %>
	</table>
	
	<%
	} %>
	<%
	} %>
	
	
	
</body>
</html>
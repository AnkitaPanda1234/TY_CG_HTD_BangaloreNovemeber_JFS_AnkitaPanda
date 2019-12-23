<%@page import="com.capgemini.mywebapp.bean.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false" %>
    
    
    
    
   <%EmployeeInfoBean employeeInfoBean=(EmployeeInfoBean)request.getAttribute("employeeInfoBean"); %> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <fieldset>
		<legend>Search Employee</legend>
		<form action="./searchEmployee3" method="get">
			Employee Id:<Input type="number" name="empId" requird><br>
			<Input type="submit" value="search">
		</form>
	</fieldset>
	<br><br>
	<%if(employeeInfoBean==null) {%>
	<h3 style="color:red;"> Employee ID Not Found</h3>
	<%} else{%>
 <h3 style="color:green">Details For Employee Id<%= employeeInfoBean.getEmpId()%></h3><br>
  Employee Name= <%=employeeInfoBean.getName() %>
  Age= <%=employeeInfoBean.getAge() %><br>
  Salary= <%=employeeInfoBean.getSalary() %><br>
  Designation= <%= employeeInfoBean.getDesignation() %>
	<% }%>
</body>
</html>
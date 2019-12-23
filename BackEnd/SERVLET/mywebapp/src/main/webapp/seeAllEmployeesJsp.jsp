<%@page import="com.capgemini.mywebapp.bean.EmployeeInfoBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false" %>
    <%List<EmployeeInfoBean> employeeList=
    (List<EmployeeInfoBean>)request.getAttribute("employeeList");
    
    String msg=(String)request.getAttribute("msg");
    
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <h4></h4><a href=./home>Home</a></h4>
   
   <%if(employeeList!=null && !employeeList.isEmpty()){ %>
 <table>
  <tr>
    <th>Emp Id</th>
    <th>Name</th>
    <th>Age</th>
    <th>Salary</th>
    <th>Designation</th>
  </tr>
       <%for(EmployeeInfoBean employeeInfoBean:employeeList) {%>
       <tr>
       <td><%= employeeInfoBean.getEmpId() %></td>
       <td><%=employeeInfoBean.getName() %></td>
       <td><%=employeeInfoBean.getAge() %></td>
       <td><%=employeeInfoBean.getSalary() %></td>
       <td><%=employeeInfoBean.getDesignation() %></td>
       </tr>
       
   <%} %>
 </table>

   <%} %>
   <%if(msg!=null && !msg.isEmpty()){ %>
   <h3 style="color:red;"><%=msg %></h3>
   <%} %>
   
</body>
</html>
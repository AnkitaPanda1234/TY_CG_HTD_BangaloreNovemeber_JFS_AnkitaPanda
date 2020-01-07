
<jsp:useBean id="user" class="com.cap.springmvc.beans.User" scope="session"></jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <h1>Welcome <%=user.getName() %></h1>
</body>
</html>
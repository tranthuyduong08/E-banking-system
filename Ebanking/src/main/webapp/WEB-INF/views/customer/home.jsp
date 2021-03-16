<%@ page import="com.ebanking.util.SecurityUtils" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>E-Banking</title>
</head>
<body>
	<h1>Welcome Customer <%=SecurityUtils.getPrincipal().getFirstName()%> <%=SecurityUtils.getPrincipal().getLastName() %>!</h1>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>E-Banking</title>
</head>
<body>
<h1>Login</h1>
<c:if test="${param.incorrectAccount != null }">
      	<div class ="alert alert-danger" align="center"> Username or password incorrect</div>
</c:if>     
<c:if test="${param.accessDenied != null }">
	<div class ="alert alert-danger" align="center"> You are not authorized</div>
</c:if>
<form action="j_spring_security_check" method="post">
  <div>
    <label for="uname"><b>Username</b></label><br>
    <input type="text" placeholder="Enter Username" name="j_username" required><br>

    <label for="pwd"><b>Password</b></label><br>
    <input type="password" placeholder="Enter Password" name="j_password" required><br>

    <button type="submit">Login</button><br>
  </div>

  <div>
    <span><a href="#">Forgot password?</a></span><br>
    <span>Don't have account in our bank? <a href="#">Register</a></span>
  </div>
</form>
</body>
</html>
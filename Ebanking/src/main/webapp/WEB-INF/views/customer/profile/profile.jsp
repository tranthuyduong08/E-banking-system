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
<h1>Profile</h1>
<div>
	<div>
		<label>First Name: </label>
		<a>${user.firstName}</a>
	</div>
	
	<div>
		<label>Last Name: </label>
		<a>${user.lastName}</a>
	</div>
	
	<div>
		<label>Gender: </label>
		<a>${user.gender}</a>
	</div>
	
	<div>
		<label>DOB: </label>
		<a>${user.dob}</a>
	</div>
	
	<div>
		<label>Email: </label>
		<a>${user.email}</a>
	</div>
	
	<div>
		<label>Phone: </label>
		<a>${user.phone}</a>
	</div>
	
	<div>
		<label>Nationality: </label>
		<a>${user.nationality}</a>
	</div>
	
	<div>
		<label>City: </label>
		<a>${user.city}</a>
	</div>
	
	<div>
		<label>Address: </label>
		<a>${user.address}</a>
	</div>
	
	<div>
		<label>Salary: </label>
		<a>${user.salary}</a>
	</div>
	
	<div>
		<label>Username: </label>
		<a>${user.username}</a>
	</div>
</div>
<a href="<c:url value='/customer/profile/edit'/>">Edit Profile</a>
<a href="">Change password</a>
<a href="">Change pincode</a>
</body>
</html>
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
	<h1>Customer List</h1>
	<table>
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Gender</th>
			<th>Dob</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Nationality</th>
			<th>City</th>
			<th>Address</th>
			<th>Salary</th>
			<th>Username</th>
			<th>Password</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach var="user" items="${user}" varStatus="i">
		<tr>
			<td>${i.index +1 }</td>
			<td>${user.firstName }</td>
			<td>${user.lastName }</td>
			<td>${user.gender }</td>
			<td>${user.dob }</td>
			<td>${user.email }</td>
			<td>${user.phone }</td>
			<td>${user.nationality }</td>
			<td>${user.city }</td>
			<td>${user.address }</td>
			<td>${user.salary }</td>
			<td>${user.username }</td>
			<td>${user.password }</td>
			<td><a href="<c:url value='/admin/customer/edit/${user.id}'/>">Edit</a></td>
			<td><a href="<c:url value='/admin/customer/delete'/>">Delete</a></td>
		</tr>
		</c:forEach>
	</table>
	<a href="<c:url value='/admin/customer/create'/>">Create new customer</a>
</body>
</html>
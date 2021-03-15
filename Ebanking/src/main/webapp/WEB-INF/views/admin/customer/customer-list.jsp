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
			<th>Contact</th>
			<th>Nationality</th>
			<th>City</th>
			<th>Address</th>
			<th>Salary</th>
			<th>Username</th>
			<th>Password</th>
			<th></th>
			<th></th>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><a href="<c:url value='/admin/customer/edit'/>">Edit</a></td>
			<td><a href="<c:url value='/admin/customer/delete'/>">Delete</a></td>
		</tr>
	</table>
	<a href="<c:url value='/admin/customer/create'/>">Create new customer</a>
</body>
</html>
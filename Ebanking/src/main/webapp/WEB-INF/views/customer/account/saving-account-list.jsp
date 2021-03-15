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
	<h1>Saving Account</h1>
	<table>
		<tr>
			<th>Id</th>
			<th>Initial Amount</th>
			<th>Tenor</th>
			<th>Open Date</th>
			<th>Close Date</th>
			<th>Description</th>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</table>
	<a href="<c:url value='/customer/saving-account/create'/>">Create New Saving Account</a>
</body>
</html>
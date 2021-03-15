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
	<h1>Transfer History</h1>
	<table>
		<tr>
			<th>Id</th>
			<th>Type</th>
			<th>Amount</th>
			<th>Receiver</th>
			<th>Date</th>
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
	<a href="<c:url value='/customer/transaction/transfer/same-bank'/>">Transfer same bank</a>
	<a href="<c:url value='/customer/transaction/transfer/other-bank'/>">Transfer other bank</a>
</body>
</html>
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
	<h1>Deposit</h1>
	<form action="<c:url value='/customer/transaction/deposit'/>" method="post">
		  <div>    
		    <label for="type"><b>Type</b></label><br>
		    <input type="text" placeholder="Enter Type" name="type" required><br>
		    
		    <label for="amount"><b>Amount</b></label><br>
		    <input type="text" placeholder="Enter Amount" name="amount" required><br>
		    
		    <label for="receiver"><b>Receiver</b></label><br>
		    <input type="text" placeholder="Enter Receiver" name="receiver" required><br>
		    
		    <label for="date"><b>Date</b></label><br>
		    <input type="date" placeholder="Enter DOB" name="date" required><br>
		    
		    <label for="description"><b>Description</b></label><br>
		    <input type="text" placeholder="Enter Description" name="description"><br>
		    
		    <button type="submit">Deposit</button><br> 
		  </div>
	</form>
	<a href="<c:url value='/customer/transaction/deposit/history'/>">Show Deposit History</a>
</body>
</html>
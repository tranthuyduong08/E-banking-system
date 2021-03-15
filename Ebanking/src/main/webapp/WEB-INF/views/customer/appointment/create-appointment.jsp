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
	<h1>Create New Appointment</h1>
	<form action="<c:url value='/customer/appointment/create'/>" method="post">
		  <div>    
		    <label for="name"><b>First Name</b></label><br>
		    <input type="text" placeholder="Enter First Name" name="name" required><br>
		    
		    <label for="name"><b>Last Name</b></label><br>
		    <input type="text" placeholder="Enter Last Name" name="name" required><br>
		    
		    <label for="name"><b>Identity Card Number</b></label><br>
		    <input type="text" placeholder="Enter IC Number" name="name" required><br>
		    
		    <label for="service"><b>Service</b></label><br>
		    <input type="text" placeholder="Enter Service Name" name="service" required><br>
		    
		    <label for="date"><b>Date</b></label><br>
		    <input type="date" placeholder="Enter Date" name="date" required><br>
		    
		    <label for="description"><b>Description</b></label><br>
			<textarea name="description" placeholder="Enter Description" rows="10" cols="30"></textarea><br>

			<button type="submit">Create</button><br> 
		  </div>
	</form>
	<a href="<c:url value='/customer/appointment'/>">Show Appointment List</a>
</body>
</html>
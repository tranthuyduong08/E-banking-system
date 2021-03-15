<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>E-Banking</title>
</head>
<body>
<h1>Edit Profile</h1>
<form action="<c:url value='/customer/profile/edit'/>" method="post">
  <div>    
    <label for="firstname"><b>First Name</b></label><br>
    <input type="text" placeholder="Enter First Name" name="firstname" required><br>
    
    <label for="lastname"><b>Last Name</b></label><br>
    <input type="text" placeholder="Enter Last Name" name="lastname" required><br>
    
    <label for="gender"><b>Gender</b></label><br>
    <input type="text" placeholder="Enter Gender" name="gender" required><br>
    
    <label for="dob"><b>DOB</b></label><br>
    <input type="date" placeholder="Enter DOB" name="dob" required><br>
    
    <label for="email"><b>Email</b></label><br>
    <input type="email" placeholder="Enter Email" name="email" required><br>
    
    <label for="phone"><b>Phone</b></label><br>
    <input type="text" placeholder="Enter Phone" name="phone" required><br>
    
    <label for="nationality"><b>Nationality</b></label><br>
    <input type="text" placeholder="Enter Nationality" name="nationality" required><br>
    
    <label for="city"><b>City</b></label><br>
    <input type="text" placeholder="Enter City" name="city" required><br>
    
    <label for="address"><b>Address</b></label><br>
    <input type="text" placeholder="Enter Address" name="address" required><br>
    
    <label for="salary"><b>Salary</b></label><br>
    <input type="text" placeholder="Enter Salary" name="salary" required><br>
    
    <label for="username"><b>Username</b></label><br>
    <input type="text" placeholder="Enter Username" name="username" required><br>

    <label for="password"><b>Password</b></label><br>
    <input type="password" placeholder="Enter Password" name="password" required><br>

    <button type="submit">Update</button><br> 
  </div>
</form>
</body>
</html>
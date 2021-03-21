<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<div class="sufee-login d-flex align-content-center flex-wrap">
	<div class="container">
		<div class="login-content">
			<div class="login-logo">
				<a href="<c:url value='/home'/>"> <img class="align-content"
					src="<c:url value='/template/admin/images/logo.png'/>" alt="">
				</a>
			</div>
			<br>
			<div class="login-form">
				<form>
					<div class="form-group">
						<label>User Name</label> <input type="email" class="form-control"
							placeholder="User Name">
					</div>
					<div class="form-group">
						<label>Email address</label> <input type="email"
							class="form-control" placeholder="Email">
					</div>
					<div class="form-group">
						<label>Password</label> <input type="password"
							class="form-control" placeholder="Password">
					</div>
					<div class="checkbox">
						<label> <input type="checkbox"> Agree the terms and policy
						</label>
					</div>
					<button type="submit" class="btn btn-success btn-flat m-b-30 m-t-30">Register</button>
					
					<div class="register-link m-t-15 text-center">
						<p>
							Already have account ? <a href="<c:url value='/login'/>">Login</a>
						</p>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<%@ page import="com.ebanking.util.SecurityUtils" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="breadcrumbs">
	<div class="breadcrumbs-inner">
		<div class="row m-0">
			<div class="col-sm-4">
				<div class="page-header float-left">
					<div class="page-title">
						<h1>Profile</h1>
					</div>
				</div>
			</div>
			<div class="col-sm-8">
				<div class="page-header float-right">
					<div class="page-title">
						<ol class="breadcrumb text-right">
							<li><a href="#">Dashboard</a></li>
							<li><a href="#">Extras</a></li>
							<li class="active">Profile</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="content">
	<div class="animated fadeIn">
		<div class="row">
			<div class="col-lg-6">
				<div class="card">
					<div class="card-header">
						<strong>Change</strong> Password
					</div>
					<div class="card-body card-block">
						<form action="<c:url value='/admin/profile/edit'/>" method="post" enctype="multipart/form-data"
							class="form-horizontal">
							<div class="row form-group">
								<div class="col col-md-3">
									<label class=" form-control-label">Username</label>
								</div>
								<div class="col-12 col-md-9">
									<input type="text" placeholder="Enter Username" name="username" value="${user.username}" disabled="" 
									class="form-control">
								</div>
							</div>							
							<div class="row form-group">
								<div class="col col-md-3">
									<label for="password-input" class=" form-control-label">Password</label>
								</div>
								<div class="col-12 col-md-9">
									<input type="password" id="password-input" placeholder="Enter Password" name="password" value=""
									class="form-control">
									<small class="help-block form-text">Please enter a complex password</small>
								</div>
							</div> 
							<hr>
							<div class="row form-group">							
								<button type="submit" class="btn btn-primary btn-sm">
									<i class="fa fa-dot-circle-o"></i> Submit
								</button>
								<button type="reset" class="btn btn-danger btn-sm">
									<i class="fa fa-ban"></i> Reset
								</button>
							</div>
						</form>
					</div>					
				</div>
			</div>
		</div>
	</div>
	<!-- .animated -->
</div>
<!-- .content -->
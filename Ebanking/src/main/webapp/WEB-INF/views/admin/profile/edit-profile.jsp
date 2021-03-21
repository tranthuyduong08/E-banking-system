<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
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
							<li><a href="<c:url value='/admin'/>">Dashboard</a></li>
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
		<div class="row justify-content-center">
			<div class="col-lg-6">
				<div class="card">
					<div class="card-header">
						<strong>Edit</strong> Profile
					</div>
					<div class="card-body card-block">
						<form action="<c:url value='/admin/profile/edit'/>" method="post" enctype="multipart/form-data" class="form-horizontal">
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
									<label for="text-input" class=" form-control-label">First Name</label>
								</div>
								<div class="col-12 col-md-9">
									<input type="text" id="text-input" placeholder="Enter First Name" name="firstname" value="${user.firstName}"
									disabled="" class="form-control">
									<small class="form-text text-muted">This is a help text</small>
								</div>
							</div>
							<div class="row form-group">
								<div class="col col-md-3">
									<label for="text-input" class=" form-control-label">Last Name</label>
								</div>
								<div class="col-12 col-md-9">
									<input type="text" id="text-input" placeholder="Enter Last Name" name="lastname" value="${user.lastName}"
									disabled="" class="form-control">
								</div>
							</div>
							<div class="row form-group">
								<div class="col col-md-3">
									<label for="text-input" class=" form-control-label">Gender</label>
								</div>
								<div class="col-12 col-md-9">
									<input type="text" id="text-input" placeholder="Enter Gender" name="gender" value="${user.gender}"
									disabled="" class="form-control">
								</div>
							</div>
							<div class="row form-group">
								<div class="col col-md-3">
									<label for="text-input" class=" form-control-label">Date of Birth</label>
								</div>
								<div class="col-12 col-md-9">
									<input type="date" id="text-input" placeholder="Enter DOB" name="dob" value="${user.dob}"
									disabled="" class="form-control">
								</div>
							</div>
							<div class="row form-group">
								<div class="col col-md-3">
									<label for="email-input" class=" form-control-label">Email </label>
								</div>
								<div class="col-12 col-md-9">
									<input type="email" id="email-input" placeholder="Enter Email" name="email" value="${user.email}"
									class="form-control">
								</div>
							</div>
							<div class="row form-group">
								<div class="col col-md-3">
									<label for="email-input" class=" form-control-label">Phone </label>
								</div>
								<div class="col-12 col-md-9">
									<input type="text" id="text-input" placeholder="Enter Phone" name="phone" value="${user.phone}"
									class="form-control">
								</div>
							</div>
							<div class="row form-group">
								<div class="col col-md-3">
									<label for="email-input" class=" form-control-label">Nationality </label>
								</div>
								<div class="col-12 col-md-9">
									<input type="text" id="text-input" placeholder="Enter Nationality" name="nationality" value="${user.nationality}"
									disabled="" class="form-control">
								</div>
							</div>
							<div class="row form-group">
								<div class="col col-md-3">
									<label for="email-input" class=" form-control-label">City </label>
								</div>
								<div class="col-12 col-md-9">
									<input type="text" id="text-input" placeholder="Enter City" name="city" value="${user.city}"
									disabled="" class="form-control">
								</div>
							</div>
							<div class="row form-group">
								<div class="col col-md-3">
									<label for="email-input" class=" form-control-label">Address </label>
								</div>
								<div class="col-12 col-md-9">
									<input type="text" id="text-input" placeholder="Enter Address" name="address" value="${user.address}"
									disabled="" class="form-control">
								</div>
							</div>
							<div class="row form-group">
								<div class="col col-md-3">
									<label for="email-input" class=" form-control-label">Salary </label>
								</div>
								<div class="col-12 col-md-9">
									<input type="text" id="text-input" placeholder="Enter Salary" name="salary" value="${user.salary}"
									disabled="" class="form-control">
								</div>
							</div>							
							<hr>
							<div class="">							
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
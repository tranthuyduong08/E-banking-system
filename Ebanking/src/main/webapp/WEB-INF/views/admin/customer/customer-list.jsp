<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="breadcrumbs">
	<div class="breadcrumbs-inner">
		<div class="row m-0">
			<div class="col-sm-4">
				<div class="page-header float-left">
					<div class="page-title">
						<h1>Customer Management</h1>
					</div>
				</div>
			</div>
			<div class="col-sm-8">
				<div class="page-header float-right">
					<div class="page-title">
						<ol class="breadcrumb text-right">
							<li><a href="<c:url value='/admin'/>">Dashboard</a></li>
							<li><a href="#">Customer</a></li>
							<li class="active">Customer Management</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!--
<div class="content">
	<div class="animated fadeIn">
		<div class="row">
			<div class="col-lg-12">
				<div class="card">
					<div class="card-header">
						<strong class="card-title">CUSTOMER LIST</strong>
					</div>
					<div class="card-body">
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Id</th>
									<th scope="col">First Name</th>
									<th scope="col">Last Name</th>
									<th scope="col">Gender</th>
									<th scope="col">Dob</th>
									<th scope="col">Email</th>
									<th scope="col">Phone</th>
									<th scope="col">Nationality</th>
									<th scope="col">City</th>
									<th scope="col">Address</th>
									<th scope="col">Salary</th>
									<th scope="col">Username</th>
									<th scope="col"></th>
									<th scope="col"></th>
								</tr>
							</thead>
							<tbody>
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
										<td><a href="<c:url value='/admin/customer/edit/${user.id}'/>">Edit</a></td>
										<td><a href="<c:url value='/admin/customer/delete'/>">Delete</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div> <!-- .animated -->
<!--</div>  .content -->

<div class="content">
	<div class="animated fadeIn">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-header">
						<strong class="card-title">CUSTOMER LIST</strong>
					</div>
					<div class="card-body">
						<table id="bootstrap-data-table"
							class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>Full Name</th>
									<th>Username</th>
									<th>Number of Accounts</th>			
									<th>Status</th>
									<th></th>	
									<th></th>													
								</tr>
							</thead>
							<tbody>
								<c:forEach var="user" items="${user}" varStatus="i">
									<tr>
										<td>${user.firstName } ${user.lastName }</td>
										<td>${user.username }</td>
										<td>${accountNo}</td>
										<td></td>										
										<td><a href="<c:url value='/admin/customer/edit/${user.id}'/>"><i class="fa fa-edit"></i></a></td>
										<td><a href="<c:url value='/admin/customer/delete/${user.id}'/>"><i class="fa fa-list"></i></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- .animated -->
</div>
<!-- .content -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="breadcrumbs">
	<div class="breadcrumbs-inner">
		<div class="row m-0">
			<div class="col-sm-4">
				<div class="page-header float-left">
					<div class="page-title">
						<h1>PRIMARY ACCOUNT</h1>
					</div>
				</div>
			</div>
			<div class="col-sm-8">
				<div class="page-header float-right">
					<div class="page-title">
						<ol class="breadcrumb text-right">
							<li><a href="<c:url value='/admin'/>">Dashboard</a></li>
							<li>Account</li>
							<li class="active">Primary Account</li>
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
			<div class="col-md-12">
				<div class="card">
					<div class="card-header">
						<strong class="card-title">Primary Account List</strong>
					</div>
					<div class="card-body">
						<table id="bootstrap-data-table"
							class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>#</th>
									<th>Account Number</th>
									<th>Card Number</th>
									<th>Customer Name</th>
									<th>Open Date</th>
									<th>Status</th>
									<th>Detail</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="currentAccount" items="${currentAccount}" varStatus="i">
									<tr>
										<td>${i.index +1 }</td>
										<td>${currentAccount.accNo}</td>
										<td>${currentAccount.cardNo}</td>
										<td>${currentAccount.user.firstName} ${currentAccount.user.lastName}</td>
										<td>${currentAccount.openDate}</td>
										<c:if test = "${currentAccount.status == 0}">
											<td><a style="color: red;"><i class="fa fa-times"></i> Disable</a></td>
										</c:if>
										<c:if test = "${currentAccount.status == 1}">
											<td><a style="color: green;"><i class="fa fa-check"></i> Enable</a></td>
										</c:if> 
										<td><a href="<c:url value='/admin/current-account'/>"><i class="fa fa-list"></i></a></td>
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


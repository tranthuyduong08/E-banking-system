<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="breadcrumbs">
	<div class="breadcrumbs-inner">
		<div class="row m-0">
			<div class="col-sm-4">
				<div class="page-header float-left">
					<div class="page-title">
						<h1>LOAN ACCOUNT</h1>
					</div>
				</div>
			</div>
			<div class="col-sm-8">
				<div class="page-header float-right">
					<div class="page-title">
						<ol class="breadcrumb text-right">
							<li><a href="<c:url value='/admin'/>">Dashboard</a></li>
							<li><a href="#">Account</a></li>
							<li class="active">Loan Account</li>
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
						<strong class="card-title">Loan Account List</strong>
					</div>
					<div class="card-body">
						<table id="bootstrap-data-table"
							class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>#</th>
									<th>Account Number</th>
									<th>Customer</th>
									<th>Tenor</th>
									<th>Total Amount</th>
									<th>Interest Rate(%)</th>
									<th>Status</th>
									<th></th>
									
								</tr>
							</thead>
							<tbody>
								<c:forEach var="loanAccount" items="${loanAccount}" varStatus="i">
									<tr>
										<td>${i.index +1 }</td>
										<td>${loanAccount.accNo}</td>
										<td>${loanAccount.user.firstName} ${loanAccount.user.lastName}</td>
										<td>${loanAccount.tenor}</td>
										<td>${loanAccount.totalAmount}</td>	
										<td>${loanAccount.interestRate.interestRate}</td>										
										<c:if test = "${loanAccount.status == 0}">
											<td><a style="color: gray;">Pending</a></td>
										</c:if>
										<c:if test = "${loanAccount.status == 1}">
											<td><a style="color: green;">Active</a></td>
										</c:if> 
										<c:if test = "${loanAccount.status == 2}">
											<td><a style="color: blue;">Finished</a></td>
										</c:if> 
										<td><a href="<c:url value='/admin/loan-account'/>"><i class="fa fa-edit"></i></a></td>
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
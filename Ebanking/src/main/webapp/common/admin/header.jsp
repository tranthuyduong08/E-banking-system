<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header>
	<div>
		<h1>
			<a href="<c:url value='/admin'/>"><span>E-Banking</span></a>
		</h1>
	</div>
	<nav>
		<ul>
			<li><a href="<c:url value='/admin/customer'/>">Customer</a></li>
			<li>Account
				<ul>
					<li><a href="<c:url value='/admin/current-account'/>">Current Account</a></li>
					<li><a href="<c:url value='/admin/saving-account'/>">Saving Account</a></li>
					<li><a href="<c:url value='/admin/loan-account'/>">Loan Account</a></li>
					<li><a href="<c:url value='/admin/interest-rate'/>">Interest Rate</a></li>
				</ul>
			</li>
			<li><a href="<c:url value='/admin/transaction'/>">Transaction</a>
				<ul>
					<li><a href="<c:url value='/admin/transaction/deposit'/>">Deposit</a></li>
					<li><a href="<c:url value='/admin/transaction/withdraw'/>">Withdraw</a></li>
					<li><a href="<c:url value='/admin/transaction/transfer'/>">Transfer</a></li>
				</ul>
			</li>
			<li><a href="<c:url value='/admin/profile'/>">Profile</a></li>
			<li><a href="<c:url value='/logout'/>">Logout</a></li>
		</ul>
	</nav>
</header>

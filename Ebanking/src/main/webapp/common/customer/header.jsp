<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header>
	<div>
		<h1>
			<a href="<c:url value='/customer'/>"><span>E-Banking</span></a>
		</h1>
	</div>
	<nav>
		<ul>
			<li>Account
				<ul>
					<li><a href="<c:url value='/customer/current-account'/>">Current Account</a></li>
					<li><a href="<c:url value='/customer/saving-account'/>">Saving Account</a></li>
					<li><a href="<c:url value='/customer/loan-account'/>">Loan Account</a></li>
				</ul>
			</li>
			<li><a href="<c:url value='/customer/transaction'/>">Transaction</a>
				<ul>
					<li><a href="<c:url value='/customer/transaction/deposit'/>">Deposit</a></li>
					<li><a href="<c:url value='/customer/transaction/withdraw'/>">Withdraw</a></li>
					<li><a href="<c:url value='/customer/transaction/transfer'/>">Transfer</a>
						<ul>
							<li><a href="<c:url value='/customer/transaction/transfer/same-bank'/>">Same bank</a></li>
							<li><a href="<c:url value='/customer/transaction/transfer/other-bank'/>">Other bank</a></li>
						</ul>
					</li>
				</ul>
			</li>
			
			<li><a href="<c:url value='/customer/profile'/>">Profile</a></li>
			<li><a href="<c:url value='/customer/appointment'/>">Appointment</a></li>
			<li><a href="<c:url value='/logout'/>">Logout</a></li>
		</ul>
	</nav>
</header>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="breadcrumbs">
	<div class="breadcrumbs-inner">
		<div class="row m-0">
			<div class="col-sm-4">
				<div class="page-header float-left">
					<div class="page-title">
						<h1>APPOINTMENT</h1>
					</div>
				</div>
			</div>
			<div class="col-sm-8">
				<div class="page-header float-right">
					<div class="page-title">
						<ol class="breadcrumb text-right">
							<li><a href="<c:url value='/admin'/>">Dashboard</a></li>
							<li><a href="#">Appointment</a></li>
							<li class="active">Appointment</li>
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
						<strong class="card-title">Appointment List</strong>
					</div>
					<div class="card-body">
						<table id="bootstrap-data-table"
							class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>#</th>
									<th>Customer</th>
									<th>Appointment Name</th>	
									<th>Date</th>
									<th>Status</th>
									<th></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="appointment" items="${appointment}" varStatus="i">
									<tr>
										<td>${i.index +1 }</td>
										<td>${appointment.user.firstName} ${appointment.user.lastName}</td>	
										<td>${appointment.name}</td>
										<td>${appointment.date}</td>
										<c:if test = "${appointment.status == 0}">
											<td><a style="color: grey;"><i class="fa fa-spinner"></i> Pending</a></td>
										</c:if>
										<c:if test = "${appointment.status == 1}">
											<td><a style="color: green;"><i class="fa fa-check"></i> Accepted</a></td>
										</c:if>
										<c:if test = "${appointment.status == 0}">
											<td><a style="color: grey;" href="#mediumModal" class="deleteBTN" data-toggle="modal" data-target="#mediumModal">
													<i class="fa fa-square-o"></i>
												</a>
												<input type="hidden" id="id" value="${appointment.id}" /><input type="hidden" id="id" value="${appointment.id}" />
											</td>
										</c:if>
										<c:if test = "${appointment.status == 1}">
											<td><a style="color: green;"><i class="fa fa-check-square"></i></a></td>
										</c:if> 
										<td><a href="<c:url value='/admin/appointment/detail/${appointment.id}'/>"><i class="fa fa-list"></i></a></td>																	
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		
		<div class="modal fade" id="mediumModal" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg" role="document">
	            <form method="post" action="<c:url value='/admin/appointment/verify'/>">
	                <div class="modal-content">
	                    <div class="modal-header">
	                        <h5 class="modal-title" id="mediumModalLabel">Accept Appointment Record</h5>
	                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	                            <span aria-hidden="true">&times;</span>
	                        </button>
	                    </div>
	                    <div class="modal-body">
	                        <p>This appointment will be verified as valid appointment. Do you want to continue?</p>
	                    </div>
	                    <div class="modal-footer">
	                        <input type="button" class="btn btn-secondary" data-dismiss="modal" value="Cancel">
	                        <input type="submit" class="btn btn-primary" value="Accept" />
	                        <input type="hidden" name="id" id="id" />
	                    </div>
	                </div>
	            </form>
            </div>
        </div> 
	</div>
	<!-- .animated -->
</div>
<!-- .content -->

<script type="text/javascript">
	jQuery(document).ready(function($) {
		jQuery('table .deleteBTN').on('click', function($){
			var id = jQuery(this).parent().find('#id').val();
			jQuery('#mediumModal #id').val(id);	 
		});
	});
</script>
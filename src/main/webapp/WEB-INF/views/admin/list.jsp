<%@include file="/layout/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách bài viết</title>
</head>

<body>
	<div id="layoutSidenav_content">
	<form action="<c:url value='/home-admin/listProduct'/>" id="formSubmit" method="get">
		<div class="main-content">
			
			

				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li><i class="ace-icon fa fa-home home-icon"></i> <a
								href="#">Trang chủ</a></li>
						</ul>
						<!-- /.breadcrumb -->
					</div>
					<div style="background-color: #e4e6e9" class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<c:if test="${not empty message}">
									<div class="alert alert-"></div>
								</c:if>
								<div class="widget-box table-filter">
									<div class="table-btn-controls">
										<div class="pull-right tableTools-container">
											<div class="dt-buttons btn-overlap btn-group">
												<c:url var="createNewURL" value="/home-admin/editProduct" />
												<a flag="info" class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip" title='Thêm bài viết' href='${createNewURL}'> 
													<span>
															<i class="fa fa-plus-circle bigger-110 purple"></i>
													</span>
												</a>
												<button id="btnDelete" type="button" onclick="warningBeforeDelete()" class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" data-toggle="tooltip" title='Xóa bài viết'>
													<span> 
														<i class="fa fa-trash-o bigger-110 pink"></i>
													</span>
												</button>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12">
										<div class="table-responsive">
											<table class="table table-bordered">
												<thead>
													<tr>
														<th><input type="checkbox" id="checkAll"></th>
														<th>Tên sản phẩm</th>
														<th>Mô tả ngắn</th>
														<th>Số lượng</th>
														<th>Thao tác</th>
													</tr>
												</thead>

												<tbody>
													<c:forEach var="item" items="${model.listResult}">
														<tr>
															<td><input type="checkbox" id="checkbox_" value=""></td>
															<td>${item.title}</td>
															<td>${item.summary}</td>
															<td>${item.quantity}</td>
															<td>
																<c:url var="updateNewURL" value="/home-admin/editProduct">
																	<c:param name="id" value="${item.id}"/>															
																</c:url>																
																<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
																   title="Cập nhật bài viết" href='${updateNewURL}'><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
																</a>
															</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
											<ul class="pagination" id="pagination"></ul>	
											<input type="hidden" value="" id="page" name="page"/>
											<input type="hidden" value="" id="limit" name="limit"/>		
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			
		</div>
		</form>
	</div>
	<script>
		var totalPages = ${model.totalPage};
		var currentPage = ${model.page};
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPages,
				visiblePages : 30,
				startPage : currentPage,
				onPageClick : function(event, page) {
					if (currentPage != page) {
						$('#limit').val(30);
						$('#page').val(page);
						$('#formSubmit').submit();
					}
				}
			});
		});
	</script>
	<!-- /.main-content -->
</body>
</html>
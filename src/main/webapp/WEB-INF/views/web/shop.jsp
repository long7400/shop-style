<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/layout/taglib.jsp"%>
<c:url var="newURL" value="/home-page/shop-page" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<c:url value='/home-page/shop-page'/>" id="formSubmit"
		method="get">
		<!-- Page Header Start -->
		<div class="container-fluid bg-secondary mb-5">
			<div
				class="d-flex flex-column align-items-center justify-content-center"
				style="min-height: 300px">
				<h1 class="font-weight-semi-bold text-uppercase mb-3">Our Shop</h1>
				<div class="d-inline-flex">
					<p class="m-0">
						<a href="">Home</a>
					</p>
					<p class="m-0 px-2">-</p>
					<p class="m-0">Shop</p>
				</div>
			</div>
		</div>
		<!-- Page Header End -->


		<!-- Shop Start -->
		<div class="container-fluid pt-5">
			<div class="row px-xl-5">
				<!-- Shop Sidebar Start -->
				<div class="col-lg-9 col-md-12">
					<div class="row pb-3">
						<div class="col-12 pb-1">
							<div
								class="d-flex align-items-center justify-content-between mb-4">
								<form action="${pageContext.request.contextPath}/home-page/shop-page2?page=1&limit=2">
									<div class="input-group">
										<input type="text" class="form-control" name="productName"
											placeholder="Search by name">
										<div class="input-group-append">
											<button class="input-group-text bg-transparent text-primary">
												<i class="fa fa-search"></i>
											</button>
										</div>
									</div>
								</form>
								
							</div>
						</div>

						<c:forEach var="item" items="${model.listResult}">
							<div class="col-lg-4 col-md-6 col-sm-12 pb-1">
								<div class="card product-item border-0 mb-4">
									<div
										class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
										<img class="img-fluid w-100"
											src='${item.image}' />
									</div>
									<div
										class="card-body border-left border-right text-center p-0 pt-4 pb-3">
										<h6 class="text-truncate mb-3">${item.title}</h6>
										<div class="d-flex justify-content-center">
											<h6>${item.price} VND</h6>
										</div>
									</div>
									<div
										class="card-footer d-flex justify-content-between bg-light border">
										<c:url var="updateCategoryURL" value="/home-page/detail-page">
											<c:param name="id" value="${item.id}" />
										</c:url>
										<a href='${updateCategoryURL}'
											class="btn btn-sm text-dark p-0"><i
											class="fas fa-eye text-primary mr-1"></i>View Detail</a> <a
											href="javascript:;" onclick="addToCart(${item.id})"
											class="btn btn-sm text-dark p-0"><i
											class="fas fa-shopping-cart text-primary mr-1"></i>Add To
											Cart</a>
									</div>
								</div>
							</div>
						</c:forEach>


					</div>


					<div class="col-12 pb-1">
						<ul class="pagination" id="pagination"></ul>
						<input type="hidden" value="" id="page" name="page" /> <input
							type="hidden" value="" id="limit" name="limit" />
					</div>
				</div>
			</div>
			<!-- Shop Product End -->
		</div>
	</form>

	<script type="text/javascript">
	var totalPages = ${model.totalPage};
	var currentPage = ${model.page};
	$(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: 2,
            startPage: currentPage,
            onPageClick: function (event, page) {
            	if (currentPage != page) {
            		$('#limit').val(2);
					$('#page').val(page);
					$('#formSubmit').submit();
				}
            }
        });
    });
</script>
</body>
</html>
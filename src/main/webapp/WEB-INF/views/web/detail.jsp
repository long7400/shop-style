<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/layout/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Page Header Start -->
	<div class="container-fluid bg-secondary mb-5">
		<div
			class="d-flex flex-column align-items-center justify-content-center"
			style="min-height: 300px">
			<h1 class="font-weight-semi-bold text-uppercase mb-3">Shop
				Detail</h1>
			<div class="d-inline-flex">
				<p class="m-0">
					<a href="">Home</a>
				</p>
				<p class="m-0 px-2">-</p>
				<p class="m-0">Shop Detail</p>
			</div>
		</div>
	</div>
	<!-- Page Header End -->
	<form:form style="background-color: #e4e6e9;"
		class="well form-horizontal" action="" method="post" id="formSubmit"
		modelAttribute="model">
		<!-- Shop Detail Start -->
		<div class="container-fluid py-5" style="background: white">
			<div class="row px-xl-5">
				<div class="col-lg-5 pb-5">
					<div id="product-carousel" class="carousel slide"
						data-ride="carousel">
						<div class="carousel-inner border">
							<div class="carousel-item active">
								<img class="w-100 h-100" src="${model.image}" alt="Image">
							</div>
						</div>
						<a class="carousel-control-prev" href="#product-carousel"
							data-slide="prev"> <i
							class="fa fa-2x fa-angle-left text-dark"></i>
						</a> <a class="carousel-control-next" href="#product-carousel"
							data-slide="next"> <i
							class="fa fa-2x fa-angle-right text-dark"></i>
						</a>
					</div>
				</div>

				<div class="col-lg-7 pb-5">
					<form:label path="title">${model.title}</form:label>
					<div class="d-flex mb-3">
						<div class="text-primary mr-2">
							<small class="fas fa-star"></small> <small class="fas fa-star"></small>
							<small class="fas fa-star"></small> <small
								class="fas fa-star-half-alt"></small> <small class="far fa-star"></small>
						</div>
					</div>
					<form:label path="price">${model.price}</form:label>

					<p class="mb-4">
						<form:label path="content">${model.content}</form:label>
					</p>
						<a href="javascript:;" onclick="addToCart(${model.id})"
							class="btn btn-sm text-dark p-0"><i
							class="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart</a>
					</div>
				</div>
			</div>
			<div class="row px-xl-5">
				<div class="col">
					<div
						class="nav nav-tabs justify-content-center border-secondary mb-4">
						<a class="nav-item nav-link active" data-toggle="tab"
							href="#tab-pane-1">Description</a>
					</div>
					<div class="tab-content">
						<div class="tab-pane fade show active" id="tab-pane-1">
							<h4 class="mb-3">Product Description</h4>
							<p>
								<form:label path="summary">${model.summary}</form:label>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Shop Detail End -->


	</form:form>
	<!-- Products End -->
</body>
</html>
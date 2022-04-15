<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/layout/taglib.jsp" %>
<%@ page import="com.shopstyle.util.SecurityUtils" %>
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
			<h1 class="font-weight-semi-bold text-uppercase mb-3">Checkout</h1>
			<div class="d-inline-flex">
				<p class="m-0">
					<a href="">Home</a>
				</p>
				<p class="m-0 px-2">-</p>
				<p class="m-0">Checkout</p>
			</div>
		</div>
	</div>
	<!-- Page Header End -->

<form:form action="${pageContext.request.contextPath}/checkOut" modelAttribute="carts" method="post">
	<!-- Checkout Start -->
	<div class="container-fluid pt-5">
		<div class="row px-xl-5">
			<div class="col-lg-8">
				<div class="mb-4">
					<h4 class="font-weight-semi-bold mb-4">Billing Address</h4>
					<div class="row">
					
						<div class="col-md-6 form-group">
							<label>Name</label> <input class="form-control" type="text"
								placeholder="NguyenVanA">
						</div>

						<div class="col-md-6 form-group">
							<label>Address</label> <input class="form-control"
								type="text" placeholder="123 Street">
						</div>
						
						<div class="col-md-6 form-group">
							<label>Phone Number</label> <input class="form-control"
								type="text" placeholder="123 Street">
						</div>
						
					</div>
				</div>
				<div class="collapse mb-4" id="shipping-address">
					<h4 class="font-weight-semi-bold mb-4">Shipping Address</h4>
					<div class="row">
						<div class="col-md-6 form-group">
							<label>First Name</label> <input class="form-control" type="text"
								placeholder="John">
						</div>
						<div class="col-md-6 form-group">
							<label>Last Name</label> <input class="form-control" type="text"
								placeholder="Doe">
						</div>
						<div class="col-md-6 form-group">
							<label>E-mail</label> <input class="form-control" type="text"
								placeholder="example@email.com">
						</div>
						<div class="col-md-6 form-group">
							<label>Mobile No</label> <input class="form-control" type="text"
								placeholder="+123 456 789">
						</div>
						<div class="col-md-6 form-group">
							<label>Address Line 1</label> <input class="form-control"
								type="text" placeholder="123 Street">
						</div>
						<div class="col-md-6 form-group">
							<label>Address Line 2</label> <input class="form-control"
								type="text" placeholder="123 Street">
						</div>
						<div class="col-md-6 form-group">
							<label>Country</label> <select class="custom-select">
								<option selected>United States</option>
								<option>Afghanistan</option>
								<option>Albania</option>
								<option>Algeria</option>
							</select>
						</div>
						<div class="col-md-6 form-group">
							<label>City</label> <input class="form-control" type="text"
								placeholder="New York">
						</div>
						<div class="col-md-6 form-group">
							<label>State</label> <input class="form-control" type="text"
								placeholder="New York">
						</div>
						<div class="col-md-6 form-group">
							<label>ZIP Code</label> <input class="form-control" type="text"
								placeholder="123">
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-4">
				<div class="card border-secondary mb-5">
					<div class="card-header bg-secondary border-0">
						<h4 class="font-weight-semi-bold m-0">Order Total</h4>
					</div>
					<div class="card-body">
						<h5 class="font-weight-medium mb-3">Products</h5>
						 <c:forEach var="cartItemDTO" items="${carts.cartItemDTOS}" varStatus="loop">
			
								<div class="d-flex justify-content-between">
									<p>${cartItemDTO.product_name}</p>
									<p id="totalCheckout">${cartItemDTO.price}</p>
								</div>
							
						</c:forEach>
					</div>
					<div class="card-footer border-secondary bg-transparent">
						<div class="d-flex justify-content-between mt-2">
							<h5 class="font-weight-bold">Total</h5>
							<h5 class="font-weight-bold" onload="sum(this)" id="total">$160</h5>
						</div>
					</div>
				</div>
				<div class="card border-secondary mb-5">
					
					<div class="card-footer border-secondary bg-transparent">
						<button
							class="btn btn-lg btn-block btn-primary font-weight-bold my-3 py-3">Place
							Order</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Checkout End -->
</form:form>

<script type="text/javascript">
function sum(obj){
	    let a = document.getElementById("totalCheckout").value;
	    a = Number(a);
	    let sum = a;
	 
	    document.getElementById('total').innerHTML = sum;
	}
</script>

</body>
</html>
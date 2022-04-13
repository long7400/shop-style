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
			<h1 class="font-weight-semi-bold text-uppercase mb-3">Shopping
				Cart</h1>
			<div class="d-inline-flex">
				<p class="m-0">
					<a href="">Home</a>
				</p>
				<p class="m-0 px-2">-</p>
				<p class="m-0">Shopping Cart</p>
			</div>
		</div>
	</div>
	<!-- Page Header End -->


	<!-- Cart Start -->
	<div class="container-fluid pt-5">
		<div class="row px-xl-5">
			<div class="col-lg-8 table-responsive mb-5">
				<c:if test="${carts == null }">
					<p> KHÔNG CÓ SẢN PHẨM NÀO</p>
				</c:if>
				
				<c:if test="${carts != null }">
					<table class="table table-bordered text-center mb-0">
					<thead class="bg-secondary text-dark">
						<tr>

							<th>Products Name</th>
							<th>Quantity</th>
							<th>Price</th>
							<th>Remove</th>
						</tr>
					</thead>
					<tbody class="align-middle">
						<c:forEach var="item" items="${carts}">
						<tr>
							<input type="hidden" class="align-middle" value=" ${item.product_id}" /> 
							<td class="align-middle">${item.product_name}</td>
							
							<td class="align-middle">
								<div>
									<input type="number" onclick="addToCart(${item.product_id})" value="${item.quantity}" class="form-control">
								</div>
							</td>
							<td class="align-middle">${item.price}</td>
							<td class="align-middle">
								<input type="button" value="Delete" class="btn btn-danger" />
							</td>
					
						</tr>
						</c:forEach>
					</tbody>
				</table>
				</c:if>
				
			</div>
			<div class="col-lg-4">
				<div class="card border-secondary mb-5">
					<div class="card-header bg-secondary border-0">
						<h4 class="font-weight-semi-bold m-0">Cart Summary</h4>
					</div>
					<div class="card-body">
						<div class="d-flex justify-content-between mb-3 pt-1">
							<h6 class="font-weight-medium">Subtotal</h6>
							<h6 class="font-weight-medium">$150</h6>
						</div>
						<div class="d-flex justify-content-between">
							<h6 class="font-weight-medium">Shipping</h6>
							<h6 class="font-weight-medium">$10</h6>
						</div>
					</div>
					<div class="card-footer border-secondary bg-transparent">
						<div class="d-flex justify-content-between mt-2">
							<h5 class="font-weight-bold">Total</h5>
							<h5 class="font-weight-bold">$160</h5>
						</div>
						<button class="btn btn-block btn-primary my-3 py-3">Proceed
							To Checkout</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Cart End -->

</body>
</html>
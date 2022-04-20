<%@ page import="com.shopstyle.util.SecurityUtils" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/layout/taglib.jsp"%>
<div class="container-fluid mb-5">
	<div class="row border-top px-xl-5">
		<div class="col-lg-3 d-none d-lg-block">
			<a
				class="btn shadow-none d-flex align-items-center justify-content-between bg-primary text-white w-100"
				data-toggle="collapse" href="#navbar-vertical"
				style="height: 65px; margin-top: -1px; padding: 0 30px;">
				<h6 class="m-0">Categories</h6> <i
				class="fa fa-angle-down text-dark"></i>
			</a>
			<nav
				class="collapse show navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0"
				id="navbar-vertical">
				<div class="navbar-nav w-100 overflow-hidden" style="height: 410px">
					<c:forEach var = "name" items="${menu}">
						<a href="" class="nav-item nav-link"><c:out value = "${name}"/></a>
					</c:forEach>

				</div>
			</nav>
		</div>
		<div class="col-lg-9">
			<nav
				class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
				<a href="" class="text-decoration-none d-block d-lg-none">
					<h1 class="m-0 display-5 font-weight-semi-bold">
						<span class="text-primary font-weight-bold border px-3 mr-1">E</span>Shopper
					</h1>
				</a>
				<button type="button" class="navbar-toggler" data-toggle="collapse"
					data-target="#navbarCollapse">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse justify-content-between"
					id="navbarCollapse">
					<div class="navbar-nav mr-auto py-0">
						<a href="<c:url value='/home-page'/>" class="nav-item nav-link active">Home</a> 
						<a href="<c:url value='/home-page/shop-page?page=1&limit=2'/>" class="nav-item nav-link">Shop</a>
						<a href="<c:url value='/home-page/contact-page'/>" class="nav-item nav-link">Contact</a>
					</div>
					<security:authorize access = "isAnonymous()">
						<div class="navbar-nav ml-auto py-0">
							<a href="<c:url value='/dang-nhap'/>" class="nav-item nav-link">Login</a> 
							<a href="<c:url value='/dang-ky'/>" class="nav-item nav-link">Register</a>
						</div>
					</security:authorize>
					<security:authorize access = "isAuthenticated()">
					<div class="navbar-nav ml-auto py-0">
							<a href="" class="nav-item nav-link"> Xin Chào : <%=SecurityUtils.getPrincipal().getFullName()%></a> 
							<a href="<c:url value='/thoat'/>" class="nav-item nav-link">Logout</a>
						</div>
				</security:authorize>
					
				</div>
			</nav>
			<div id="header-carousel" class="carousel slide" data-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active" style="height: 410px;">
						<img class="img-fluid" src="https://i.pinimg.com/600x315/83/10/27/8310272150b3f68855075c08319b5fde.jpg" alt="Image">
						<div
							class="carousel-caption d-flex flex-column align-items-center justify-content-center">
						</div>
					</div>
					<div class="carousel-item" style="height: 410px;">
						<img class="img-fluid" src="https://ginzburgpressfilms.com/wp-content/uploads/2017/07/T-shirt-Mock-up-vintage-retro-background-navy-1500x500.png" alt="Image">
					</div>
				</div>
				<a class="carousel-control-prev" href="#header-carousel"
					data-slide="prev">
					<div class="btn btn-dark" style="width: 45px; height: 45px;">
						<span class="carousel-control-prev-icon mb-n2"></span>
					</div>
				</a> <a class="carousel-control-next" href="#header-carousel"
					data-slide="next">
					<div class="btn btn-dark" style="width: 45px; height: 45px;">
						<span class="carousel-control-next-icon mb-n2"></span>
					</div>
				</a>
			</div>
		</div>
	</div>
</div>
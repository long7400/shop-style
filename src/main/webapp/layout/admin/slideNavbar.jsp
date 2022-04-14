<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/layout/taglib.jsp"%>

<div id="layoutSidenav_nav">
	<nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
		<div class="sb-sidenav-menu">
			<div class="nav">
				<div class="sb-sidenav-menu-heading">Core</div>
				<a class="nav-link" href="index.html">
					<div class="sb-nav-link-icon">
						<i class="fas fa-tachometer-alt"></i>
					</div> Dashboard
				</a>
				
				<a class="nav-link" href="<c:url value='/home-admin/listProduct?page=1&limit=30'/>">
					<div class="sb-nav-link-icon">
						<i class="fas fa-chart-area"> </i>
					</div> LIST PRODUCT
				</a> <a class="nav-link" href="<c:url value='/home-admin/listCategory?page=1&limit=30'/>">
					<div class="sb-nav-link-icon">
						<i class="fas fa-table"></i>
					</div> LIST CATEGORIES
				</a>
				</a> <a class="nav-link" href="<c:url value='#'/>">
					<div class="sb-nav-link-icon">
						<i class="fas fa-table"></i>
					</div> LIST CART
				</a>
			</div>
		</div>
	</nav>
</div>
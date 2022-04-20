<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/layout/taglib.jsp"%>

<div class="container-fluid bg-secondary text-dark mt-5 pt-5">
	<div class="row px-xl-5 pt-5">
		<div class="col-lg-4 col-md-12 mb-5 pr-3 pr-xl-5">
			<a href="" class="text-decoration-none">
				<h1 class="mb-4 display-5 font-weight-semi-bold">
					<span
						class="text-primary font-weight-bold border border-white px-3 mr-1">E</span>Shopper
				</h1>
			</a>
			<p>Hello Shop Style Xin Chào Quý Khách</p>
			<p class="mb-2">
				<i class="fa fa-map-marker-alt text-primary mr-3"></i>73/10B Đường
				61 Phước Long B Quận 9
			</p>
			<p class="mb-2">
				<i class="fa fa-envelope text-primary mr-3"></i>nhlongxxxx@gmail.com
			</p>
			<p class="mb-0">
				<i class="fa fa-phone-alt text-primary mr-3"></i>+84 905294xxx
			</p>
		</div>
		<div class="col-lg-8 col-md-12">
			<div class="row">
				<div class="col-md-4 mb-5">
					<h5 class="font-weight-bold text-dark mb-4">Quick Links</h5>
					<div class="d-flex flex-column justify-content-start">
						<a class="text-dark mb-2" href="<c:url value='/home-page'/>"><i
							class="fa fa-angle-right mr-2"></i>Home</a><a class="text-dark"
							href="<c:url value='/home-page/contact-page'/>"><i
							class="fa fa-angle-right mr-2"></i>Contact Us</a>
					</div>
				</div>

			</div>
		</div>
	</div>

</div>
<!-- Footer End -->


<!-- Back to Top -->
<a href="#" class="btn btn-primary back-to-top"><i
	class="fa fa-angle-double-up"></i></a>


<!-- JavaScript Libraries -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>

<script src="<c:url value='/common/web/lib/easing/easing.min.js'/> "></script>
<script
	src="<c:url value='/common/web/lib/owlcarousel/owl.carousel.min.js'/>"></script>

<!-- Contact Javascript File -->
<script
	src="<c:url value='/common/web/mail/jqBootstrapValidation.min.js'/>"></script>
<script src="<c:url value='/common/web/mail/contact.js'/>"></script>

<!-- Template Javascript -->
<script src="<c:url value='/common/web/js/main.js'/>"></script>
<script src="<c:url value='/common/paging/jquery.twbsPagination.js' />"></script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/layout/taglib.jsp"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng nhập</title>
</head>
<body>
	<div class="container">
		<!-- <h1 class="form-heading">login Form</h1> -->
		<div class="login-form">
			<div class="main-div">
			
				<form action="j_spring_security_check" id="formSubmit" method="post">
					<c:if test="${not empty message}">
						<div class="alert alert-${alert}">${message}</div>
					</c:if>
					<div class="form-group">
						<input type="text" class="form-control" id="userName" name="j_username" placeholder="Tên đăng nhập">
					</div>

					<div class="form-group">
						<input type="password" class="form-control" id="password" name="j_password" placeholder="Mật khẩu">
					</div>
					
					<div class="form-group">
						<input type="password" class="form-control" id="repassword" name="j_repassword" placeholder="Nhập lại mật khẩu">
					</div>
					<button id="dangky" type="submit" class="btn btn-primary" >Đăng nhập</button>
				</form>
			</div>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			$('#dangky').click(function(e) {
				e.preventDefault();
				var data = {};
				var formData = $('#formSubmit').serializeArray();
				console.info(formData)

			});
		});
	</script>
</body>
</html>
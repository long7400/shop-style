<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/layout/taglib.jsp"%>

<c:url var="loginURL" value="/dang-nhap" />
<c:url var="regURL" value="/dang-ky" />
<c:url var="accountAPI" value="/api/account" />
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
				<c:if test="${not empty message}">
					<div class="alert alert-${alert}">${message}</div>
				</c:if>
				<form action="j_spring_security_check" id="formSubmit" method="post">
					<c:if test="${not empty message}">
						<div class="alert alert-${alert}">${message}</div>
					</c:if>
					<div class="form-group">
						<input type="text" class="form-control" id="userName"
							name="j_username" placeholder="Tên đăng nhập">
					</div>

					<div class="form-group">
						<input type="password" class="form-control" id="password"
							name="j_password" placeholder="Mật khẩu">
					</div>

					<div class="form-group">
						<input type="password" class="form-control" id="repassword"
							name="j_repassword" placeholder="Nhập lại mật khẩu">
					</div>
					<button id="dangky" type="submit" class="btn btn-primary">Đăng
						ký</button>
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
				var inputPass1 = $('#password').val();
				var inputPass2 = $('#repassword').val();
				$.each(formData, function(i, v) {
					data["" + v.name + ""] = v.value;
				});
				if (inputPass1 == inputPass2) {
					addAccount(data)
					console.log(formData)
				} else {
					$('#password').val("");
					$('#repassword').val("");
					alert("Mật khẩu không khớp");
				}

			});

			function addAccount(data) {
				$.ajax({
					url : '${accountAPI}',
					type : 'POST',
					contentType : 'application/json',
					data : JSON.stringify(data),
					dataType : 'json',
					success : function(result) {
						window.location.href = "${loginURL}";
					},
					error : function(error) {
						window.location.href = "${regURL}";
					}
				});
			}

		});
	</script>
</body>
</html>
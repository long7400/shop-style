<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">

</head>
<body>
	<main>
	<div class="container">
		<div class="row">
			<div class="col-md-6 align-self-center">
				<h1>404</h1>
				<h2>UH OH! You're lost.</h2>
				<p>The page you are looking for does not exist. How you got here
					is a mystery. But you can click the button below to go back to the
					homepage.</p>

				<a href="<c:url value='/dang-nhap'/>"> HOME </a>

			</div>
		</div>
	</div>
	</main>
</body>
</html>
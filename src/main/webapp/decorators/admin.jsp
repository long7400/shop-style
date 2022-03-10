<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/layout/taglib.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8" />

<%@ include file="/layout/admin/header.jsp"%>
<dec:head />

</head>

<body class="sb-nav-fixed">
	<div id="layoutSidenav">
		<%@ include file="/layout/admin/navbar.jsp"%>
		<%@ include file="/layout/admin/slideNavbar.jsp"%>

		<dec:body />

		<footer class="py-4 bg-light mt-auto">
		
		</footer>
		<%@ include file="/layout/admin/footer.jsp"%>
	</div>

</body>
</html>

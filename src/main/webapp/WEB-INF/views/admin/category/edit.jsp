<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/layout/taglib.jsp"%>

<c:url var="categoryURL" value="/home-admin/listCategory" />
<c:url var="editCategoryURL" value="/home-admin/editCategory" />
<c:url var="categoryAPI" value="/api/category" />


<html>
<head>
<title>Chỉnh sửa danh mucj</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body>
	<div id="layoutSidenav_content">
		<form:form style="background-color: #e4e6e9;"
			class="well form-horizontal" action="" method="post" id="formSubmit"
			modelAttribute="model">
			<c:if test="${not empty message}">
				<div class="alert alert-${alert}">${message}</div>
			</c:if>
			<fieldset>
				<c:if test="${not empty model.id}">
					<center>
						<h2>
							<b>CẬP NHẬP DANH MỤC</b>
						</h2>
					</center>

				</c:if>
				<c:if test="${empty model.id}">
					<center>
						<h2>
							<b>THÊM DANH MỤC</b>
						</h2>
					</center>
				</c:if>


				<hr width="100%" align="center" />
				<!-- Text input-->

					<form:hidden path="id" id="categoryID"/>
					<div class="form-group">
						<label for="name" class="col-md-4 control-label">Tên danh mục</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user"></i></span>
								<form:input path="name" cssClass="form-control" />
							</div>
						</div>
					</div>
					
					<c:if test="${empty model.id}">
						<div class="form-group">
						<label for="code" class="col-md-4 control-label">Mã danh mục </label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user"></i></span>
								<form:hidden path="code" />
							</div>
						</div>
						</div>
					</c:if>
					<c:if test="${not empty model.id}">
						<div class="form-group">
						<label for="code" class="col-md-4 control-label">Mã danh mục </label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user"></i></span>
								<form:input disabled="true" path="code" />
								<form:hidden path="code" />
							</div>
						</div>
						</div>
					</c:if>
					
				

					<!-- Button -->
					<div class="form-group">
						<label class="col-md-4 control-label"></label>
						<div class="col-md-4">
							<c:url var="createCategory" value="/home-admin/editCategory" />
							<br>
							&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
							<c:if test="${not empty model.id}">
								<button type="button" class="btn btn-warning"
									id="btnAddOrUpdateNew">
									&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspUPDATE <span
										class="glyphicon glyphicon-send"></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
								</button>
	
							</c:if>
							<c:if test="${empty model.id}">
								<button type="button" class="btn btn-warning"
									id="btnAddOrUpdateNew">
									&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspADD <span
										class="glyphicon glyphicon-send"></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
								</button>
							</c:if>
							&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
							<button type="submit" class="btn btn-danger" onclick="btnBack()">
								&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspCANCEL <span
									class="glyphicon glyphicon-send"></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
							</button>
						</div>
	
	
					</div>
	
	
				</fieldset>
			</form:form>

	</div>
	<!-- /.container -->


	<script>
		$(document).ready(function() {
			$('#btnAddOrUpdateNew').click(function(e) {
				e.preventDefault();
				var data = {};
				var formData = $('#formSubmit').serializeArray();
				$.each(formData, function (i, v) {
		            data[""+v.name+""] = v.value;
		        });
				var id = $('#categoryID').val();
				if(id == ""){
					addProduct(data);
				}else{
					updateProduct(data);
				}
				console.log(formData);
			});
			
			function addProduct(data){
				$.ajax({
		            url: '${categoryAPI}',
		            type: 'POST',
		            contentType: 'application/json',
		            data: JSON.stringify(data),
		            dataType: 'json',
		            success: function (result) {
		            	window.location.href = "${categoryURL}?page=1&limit=30&message=insert_success";
		            },
		            error: function (error) {
		            	window.location.href = "${categoryURL}?page=1&limit=30&message=error_system";
		            }
		        });
			}
			
			function updateProduct(data){
				$.ajax({
		            url: '${categoryAPI}',
		            type: 'PUT',
		            contentType: 'application/json',
		            data: JSON.stringify(data),
		            dataType: 'json',
		            success: function (result) {
		            	window.location.href = "${editCategoryURL}?id="+result.id+"&message=update_success";
		            },
		            error: function (error) {
		            	window.location.href = "${editCategoryURL}?id="+result.id+"&message=error_system";
		            }
		        });
			}
			
			function btnBack() {
				window.location.href = "${categoryURL}?page=1&limit=30";
			} 

		});
	</script>
</body>
</html>

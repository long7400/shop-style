<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/layout/taglib.jsp"%>

<c:url var="newURL" value="" />
<c:url var="editNewURL" value="" />
<c:url var="newAPI" value="/api/new" />

<html>
<head>
<title>Chỉnh sửa bài viết</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body>
	<div id="layoutSidenav_content">


		<form:form style="background-color: #e4e6e9;"
			class="well form-horizontal" action="" method="post" id="formSubmit"
			modelAttribute="model">
			<fieldset>
				<c:if test="${not empty model.id}">
					<center>
						<h2>
							<b>CẬP NHẬP SẢN PHẨM</b>
						</h2>
					</center>

				</c:if>
				<c:if test="${empty model.id}">
					<center>
						<h2>
							<b>THÊM SẢN PHẨM</b>
						</h2>
					</center>
				</c:if>


				<hr width="100%" align="center" />
				<!-- Text input-->


				<div class="form-group">
					<label for="title" class="col-md-4 control-label">Tên sản
						phẩm</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span>
							<form:input path="title" cssClass="form-control" />
						</div>
					</div>
				</div>

				<!-- Text input-->

				<div class="form-group">
					<label for="content" class="col-md-4 control-label">Mô tả
						ngắn</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> 
								<form:input path="content" cssClass="form-control" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="color" class="col-md-4 control-label">Màu</label>
					<div class="col-md-4 selectContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-list"></i></span> 
								<form:select path="color" id="color">
							  	 	<form:option value="" label="-- Chọn COLOR --"/>
							  	 	<form:options items="${color}" />
							  	 </form:select>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="size" class="col-md-4 control-label">Size</label>
					<div class="col-md-4 selectContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-list"></i></span> 


						</div>
					</div>
				</div>

				<!-- Text input-->


				<div class="form-group">
					<label for="price" class="col-md-4 control-label">Giá</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> 
								<form:input path="price" cssClass="form-control" />
						</div>
					</div>
				</div>


				<div class="form-group">
					<label for="quantity" class="col-md-4 control-label">Số
						lượng</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> 
								<form:input path="quantity" cssClass="form-control" />
						</div>
					</div>
				</div>


				<div class="form-group">
					<label for="summary" class="col-md-4 control-label">Mô tả </label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span>
								<form:textarea path="summary" cssClass="form-control" id="summary" rows="5" cols="10"/>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="image" class="col-md-4 control-label">Hình ảnh</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> 
								<form:input path="image" cssClass="form-control"/>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="categoryCode" class="col-md-4 control-label">Danh
						Mục</label>
					<div class="col-md-4 selectContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-list"></i></span>
							<form:select path="categoryCode" id="categoryCode">
								<form:option value="" label="-- Chọn thể loại --" />
								<form:options items="${categories}" />
							</form:select>
						</div>
					</div>
				</div>


				<!-- Select Basic -->

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label"></label>
					<div class="col-md-4">
						<c:url var="createProduct" value="/home-admin/edit" />
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
						<button type="submit" class="btn btn-danger">
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
				var formData = $('#formSubmit').serializeArray();
				console.log(formData);
			});

		});
	</script>
</body>
</html>

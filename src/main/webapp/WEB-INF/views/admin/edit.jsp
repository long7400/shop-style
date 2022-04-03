<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/layout/taglib.jsp"%>

<html>
<head>
<title>Chỉnh sửa bài viết</title>

</head>
<body>
	<div id="layoutSidenav_content">


			<form style="background-color: #e4e6e9;" class="well form-horizontal" action=" " method="post" id="contact_form">
				<fieldset>

						<center>
							<h2>
								<b>Thêm sản phẩm</b>
							</h2>
						</center>
	
				<hr width="100%" align="center" />
				<!-- Text input-->

					<div class="form-group">
						<label class="col-md-4 control-label">Tên sản phẩm</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user"></i></span> <input name="first_name"
									placeholder="Tên sản phẩm" class="form-control" type="text">
							</div>
						</div>
					</div>

					<!-- Text input-->

					<div class="form-group">
						<label class="col-md-4 control-label">Mô tả ngắn</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user"></i></span> <input name="last_name"
									placeholder="Mô tả ngắn" class="form-control" type="text">
							</div>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-4 control-label">Màu</label>
						<div class="col-md-4 selectContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-list"></i></span> <select name="department"
									class="form-control selectpicker">
									<option value="">Chọn Màu</option>
									<option>Đỏ</option>
									<option>Vàng</option>
									<option>Cam</option>
									<option>Xanh</option>
									<option>Tím</option>
									<option>Hồng</option>
								</select>
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-4 control-label">Size</label>
						<div class="col-md-4 selectContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-list"></i></span> <select name="department"
									class="form-control selectpicker">
									<option value="">Chọn size</option>
									<option>XXL</option>
									<option>XL</option>
									<option>L</option>
									<option>M</option>
								</select>
							</div>
						</div>
					</div>

					<!-- Text input-->

					
					<div class="form-group">
						<label class="col-md-4 control-label">Giá</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user"></i></span> <input name="last_name"
									placeholder="Giá" class="form-control" type="text">
							</div>
						</div>
					</div>

					
					<div class="form-group">
						<label class="col-md-4 control-label">Số lượng</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user"></i></span> <input name="last_name"
									placeholder="Số lượng" class="form-control" type="text">
							</div>
						</div>
					</div>

					
					<div class="form-group">
						<label class="col-md-4 control-label">Mô tả </label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user"></i></span> 
									<textarea name="last_name" placeholder="Mô tả " class="form-control" style="height: 293px;" type="text"></textarea>
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-4 control-label">Hình ảnh</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user"></i></span> <input name="last_name"
									placeholder="Hình ảnh" class="form-control" type="file">
							</div>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-4 control-label">Danh Mục</label>
						<div class="col-md-4 selectContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-list"></i></span> <select name="department"
									class="form-control selectpicker">
									<option value="">Danh mục</option>
									<option>Danh mục 1</option>
									<option>Danh mục 2</option>
									<option>Danh mục 3</option>
									<option>Danh mục 4</option>
								</select>
							</div>
						</div>
					</div>
					

					<!-- Select Basic -->
					
					<!-- Button -->
					<div class="form-group">
						<label class="col-md-4 control-label"></label>
						<div class="col-md-4">
							<br>
							&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
							<button type="submit" class="btn btn-warning">
								&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspSUBMIT <span
									class="glyphicon glyphicon-send"></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
							</button>
						</div>
					</div>

				</fieldset>
			</form>
		
	</div>
	<!-- /.container -->

</body>
</html>

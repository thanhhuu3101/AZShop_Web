<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
</head>
<body>
	<c:if test="${Message!=null}">
		<span>${Message}</span>
	</c:if>
	<c:if test="${Error!=null}">
		<span>${Error}</span>
	</c:if>
	<form action="admin-insertpro" method= "post" enctype="multipart/form-data">
		<label>Nhập ProductID: </label>
		<input type= "text" name="productID"><br>
		<label>Nhập ProductName: </label>
		<input type= "text" name="productName"><br>
		<label>Nhập Des: </label>
		<textarea name= "description" cols="5" class="form-control" style="width:100%;"></textarea><br>
		<label>imageLink </label>
		<input type= "file" name="imageLink"><br>
		<label>Nhập SellerID: </label>
		<input type= "text" name="sellerID"><br>
		<label>Nhập Stoke: </label>
		<input type= "text" name="stoke"><br>
		<label for="category"> CateID: </label>
			<select name="categoryID">
				<c:forEach var ="i" items ="${listcate}">
					<option value="${i.categoryID }">${i.categoryName}</option>
				</c:forEach>
			</select>
		<input type="submit" value="Add product">	
	</form>
	
</body>
</html>
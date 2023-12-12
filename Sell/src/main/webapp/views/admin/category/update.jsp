<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Job</title>
</head>
<body>
	<form action="admin-update" method= "post" enctype="multipart/form-data">
		<label>cateID: </label>
		<input type= "text" name="CategoryID" value="${cate.categoryID}" readonly="readonly">
		<label>CateName: </label>
		<input type= "text" name="CategoryName" value="${cate.categoryName}">
		<label>icon: </label>
		<input type= "file" name="icon" value="${cate.icon}">
		<input type="submit" value="Cập nhật">
	
	
	</form>
	
</body>
</html>
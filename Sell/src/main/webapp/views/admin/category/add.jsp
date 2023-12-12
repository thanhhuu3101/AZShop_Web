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
	<c:if test="${Message!=null}">
		<span>${Message}</span>
	</c:if>
	<c:if test="${Error!=null}">
		<span>${Error}</span>
	</c:if>
	<form action="admin-insert" method= "post" enctype="multipart/form-data">
		<label>Nhập CateID: </label>
		<input type= "text" name="CategoryID">
		<label>Nhập CateName: </label>
		<input type= "text" name="CategoryName">
		<label>Thêm Icon: </label>
		<input type= "file" name="icon">
		<input type="submit" value="Thêm Cate">
	
	
	</form>
	
</body>
</html>
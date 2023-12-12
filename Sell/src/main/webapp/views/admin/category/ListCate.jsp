<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<table border="1" style="width: 100%">
		<thead>
			<th>CateID</th>
			<th>Tên Danh Mục</th>
			<th>Ảnh Đại Diện</th>
			
			<th>Hành Động</th>
		</thead>	
		<tbody>
		<c:forEach var ="i" items ="${list}">
			<tr>
				<td>${i.categoryID}</td>
				<td>${i.categoryName}</td>
				<td>${i.icon}</td>
				
				<td><a href="admin-update?id=${i.categoryID}">Update</a> ||<a href="admin-delete?id=${i.categoryID}">Delete</a> </td>
			</tr>
		</c:forEach>
		</tbody>
		
	</table>
	<a href='<c:url value ="/admin-insert"/>'><button>Add New Cate</button></a>
    
	
</body>
</html>
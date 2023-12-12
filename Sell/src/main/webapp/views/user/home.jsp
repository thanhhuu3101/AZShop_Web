<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/common/taglib.jsp" %>
<c:forEach var="item" items = "${listpro }">
	<a href='<c:url value="/detail?id=${item.productID }" />'>${item.productName}</a><br>
	<c:if test="${item.imageLink.substring(4)!='http' }">
		<img src='<c:url value= "/image?frame=products/${item.imageLink }"/>' alt="image1" width = "300px"/>
	</c:if>
	<br>
	<c:if test="${item.imageLink.substring(4)!='http'  }">
		<img src="${item.imageLink }" width = "300px" alt ="image"/>
	</c:if>
	<br>
	${item.category.categoryName }<br>
	
</c:forEach>
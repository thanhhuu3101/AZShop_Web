<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
</head>
<body>
	<c:if test="${not empty message }">${message }</c:if>
	<c:if test="${not empty error }">${error }</c:if>
	<a href='<c:url value ="/admin-insertpro"/>'>Add product</a>
	<table border="1" style="width: 100%">
		<thead>
			<th>ProductID</th>
			<th>ProductName</th>
			<th>Description</th>
			<th>Price</th>
			<th>imageLink</th>
			<th>SellerID</th>
			<th>Amount</th>
			<th>stoke</th>
			<th>CategoryID</th>
		</thead>	
		<tbody>
		<c:forEach var ="i" items ="${list}">
			<tr>
				<td>${i.productID}</td>
				<td>${i.productName}</td>
				<td>${i.description }</td>
				<td>${i.price}</td>
				<td>${i.imageLink}</td>
				<td>${i.sellerID }</td>
				<td>${i.amount}</td>
				<td>${i.stoke}</td>
				<td><a href ='<c:url value = "/user-Sell/findProductByCategory?cateid=${i.categoryID}"/>'>${i.categoryID}</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
		
</body>
</html>
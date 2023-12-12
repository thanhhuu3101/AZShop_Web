<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/common/taglib.jsp" %>
<style>
.active{
	background-color: #0062cc;
	color: #ffffff;
}
</style>
			
			<c:forEach var ="item" items="${listcate }">
				<c:forEach var = "item1" items="${countCID }">
					<c:if test="${item1.categoryID == item.cateID && item1.toal!=0}">
							
							<a href='<c:url value = "/listprocate?cateid=${item.categoryID }" />' >
								<span class="${setactive==item.categoryID?'active':'' }"> ${item.categoryName}</span> <small>(${item1.total})</small>
							</a>
						<br>
					</c:if>
				</c:forEach>
			</c:forEach>
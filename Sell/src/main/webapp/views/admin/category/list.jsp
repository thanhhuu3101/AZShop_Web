<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/common/taglib.jsp" %>
<div class="col-md-3">

	<div class="row">
	
		<form action="#" method="post" enctype="multipart/form-data">
	
			<br/>
		
			<!--<div class="form-group" hidden="hidden">
		
				
		
			</div>-->
		
			<div class="form-group">
				<label for="UserID">Category ID:</label> <input type="text"
				
				name="CategoryID" value="${category.categoryID }" id="categoryId" class="form-control" />
			
				<label for="categoryName">Category Name:</label> <input
				
				type="text" class="form-control" name="CategoryName"
				
				id="Categoryname" value="${category.categoryName }" />
			
			</div>
		
			<div class="form-group">
			
				<label for="images">Images:</label> <input type="file"
				
				class="form-control" name="icon" id="icon" value="${category.icon}"/>
			
			</div>
			
			<div class="form-group">
			
				<c:url value="/image?fname=category/${category.icon!=null?category.icon:'avatar.png'}" var="imgUrl"></c:url>
				
				<img width="50px" height="50px"
				
				src="${imgUrl}">
			
			</div>
		
                    <br/>
		
                    <hr>
		
		
			<div class="form-group">
			
				<button class="btn btn-primary"
				
				formaction="<c:url value="/admin-category/create"/>">
				
				Create <i class="fa fa-plus"></i>
				
				</button>
			
				<button class="btn btn-warning"
				
				formaction="<c:url value="/admin-category/update"/>">
				
				Update <i class="fa fa-edit"></i>
				
				</button>
			
				<button class="btn btn-danger"
				
				formaction="<c:url value="/admin-category/delete"/>">
				
				Delete <i class="fa fa-trash"></i>
				
				</button>
			
				<button class="btn btn-success"
				
				formaction="${pageContext.request.contextPath }/admin-category/reset">
				
				Reset <i class="fa fa-undo"></i>
				
				</button>
			
			</div>
			
		</form>
	
	</div>
	
</div>
	
<div class="row">

	<table class="table table-striped table-bordered table-hover" id="sample_2">
		<thead>
			<tr>
			<th>Mã</th>
			<th>Ảnh đại diện</th>	
			<th>Tên danh mục</th>				
			<th>Hành động</th>	
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${categorys}">
				<tr class="odd gradeX">
					<td>${item.categoryID}</td>
					<td>
					<c:url value="/image?fname=category/${item.Icon!=null?item.Icon:'avatar.png'}" var="imgUrl"></c:url>
					
					<img width="50px" height="50px"
					
					src="${imgUrl}"></td>

					<td>${item.categoryName}</td>
				
					<td><a
					
					href="<c:url value='/admin-category/edit?categoryId=${item.categoryID }'/>"
					
					class="center">Edit</a> | <a
					
					href="<c:url value='/admin-category/delete?categoryId=${item.categoryID }'/>"
					
					class="center">Delete</a></td>
				
				</tr>
			
			</c:forEach>
		
		</tbody>
		
	</table>
	
</div>
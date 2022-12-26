<%@ page pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>상품정보 목록</title>
	</head>
	
	<body>
		<h1>상품정보 목록</h1>
		
		<table border="1">
			<thead>
				<tr>
					<td>상품명</td>
					<td>금액</td>
					<td>등록일자</td>
					<td>등록업체명</td>
				</tr>
			</thead>
			
			<c:forEach var="product" items="${data}">
				<tr>
					<td>
						<a href="/detail?id=${product.id}">
							${product.product_name}
						</a>
					</td>
					<td>${product.price}</td>
					<td>${product.register_date}</td>
					<td><a href="#">${product.company_id}</a></td>
				</tr>
			</c:forEach>
				
		</table>
		
		<br>
		<button><a href="/">home</a></button>
		<button><a href="add">상품추가</a></button>
	</body>
</html>
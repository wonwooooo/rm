<%@ page pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<title>상품 상세</title>
	</head>
	<body>
		<h1>상품 상세</h1>
		<p>제목 : ${ data.product_name } </p>
		<p>가격 : ${ data.price }</p>
		<p>가격2 : <fmt:formatNumber type="number" maxFractionDigits="3" value="${data.price}" /></p>
		<p>등록일 : <fmt:formatDate value="${data.register_date}" pattern="yyyy.MM.dd HH:mm:ss" /></p>
		<p>등록업체 id : ${ data.company_id }</p> 
		
		
		<p>
			<a href="/update?productid=${id}">수정</a>
		</p>
		<form method="POST" action="/delete">
			<input type="hidden" name="bookId" value="${bookId}" />
			<input type="submit" value="삭제" />
		</form>
		<p>
			<a href="productlist">목록으로</a>
		</p>
	</body>
</html>
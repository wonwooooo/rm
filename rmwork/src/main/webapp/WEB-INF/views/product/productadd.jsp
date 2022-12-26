<%@ page pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>상품 추가</title>
	</head>
	<body>
		<h1>상품 추가</h1>
		<form method="POST">
			<p>상품명 : <input type="text" name="product_name" /></p>
			<p>가격 : <input type="text" name="price" /></p>
			<p>업체 id : <input type="text" name="company_id" /></p>
			<p><input type="submit" value="저장" />
		</form>
		
	
	</body>
</html>

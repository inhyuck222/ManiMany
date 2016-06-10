<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<title>Borrow Page</title>
</head>
<body>
	<!---------------------------------네비게이션 바 시작-------------------------  -->
		<jsp:include page="topMenu.jsp" flush="false"></jsp:include>
 	<!---------------------------------네비게이션 바 끝-------------------------  -->


	<div class="container">
		<h1>대여할 책 번호를 입력하세요.</h1>
		<hr />

		<form action="/ManyManiMVC/DoBorrowBook" method="post">
			책 번호 : <input type="text" name="bookNumber" /> <br />
		</form>


	</div>
	
	  <c:out value="${loginSucessObject}"></c:out>


</body>
</html>
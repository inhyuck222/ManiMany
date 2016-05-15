<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

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

	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="http://localhost:8080/ManyManiMVC/#">ManyManiSystem</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="http://localhost:8080/ManyManiMVC">Home</a></li>
			<li><a href="/ManyManiMVC/borrowBook">대여하기</a></li>
			<li><a href="/ManyManiMVC/returnBook">반납하기</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<!--     <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li> -->
			<li><a href="/ManyManiMVC/login"><span
					class="glyphicon glyphicon-log-in"></span> Login</a></li>
		</ul>
	</div>
	</nav>

<%-- 
	<%
	response.getCharacterEncoding()
		String str=${ironman2};

		if (str.equals()) {
	%>
	<script language="javascript">
		alert("URL 주소창에 주소를 직접 입력해서 접근하셨습니다.\n\n정상적인 경로를 통해 다시 접근해 주십시오.");
		document.location.href = "../index.jsp";
	</script>
	<%
		return;
		}
		%>
 --%>

	<div class="container">
		<h1>대여할 책 번호를 입력하세요.</h1>
		<hr />

		<form action="/ManyManiMVC/DoBorrowBook" method="post">
			책 번호 : <input type="text" name="bookNumber" /> <br />
		</form>


	<c:out value="${ironman2}"></c:out>

	</div>

</body>
</html>
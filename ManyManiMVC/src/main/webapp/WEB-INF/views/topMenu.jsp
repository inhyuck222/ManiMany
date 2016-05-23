<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Home</title>
</head>
<body>
	<!---------------------------------네비게이션 바 시작-------------------------  -->

	<%
		String rcv = (String) session.getAttribute("logOk");

		if (rcv != null) { // 로그인 완료 상태
	%>
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
				    <li><a href="#"><span class="glyphicon glyphicon-user"></span><%=rcv %></a></li>
				<li><a href="/ManyManiMVC/logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
			</ul>
		</div>
	</nav>
	
	<%
		} else {// 로그인이 되지 않은 상태 
	%>
	
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
	
	<%
		}
	%>


	<!---------------------------------네비게이션 바 끝-------------------------  -->
</body>
</html>

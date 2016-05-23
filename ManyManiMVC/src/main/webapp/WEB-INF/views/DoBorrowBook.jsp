<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


<title>Insert title here</title>
</head>
<body>

	<!---------------------------------네비게이션 바 시작-------------------------  -->
		<jsp:include page="topMenu.jsp" flush="false"></jsp:include>
 	<!---------------------------------네비게이션 바 끝-------------------------  -->
 	
 	<div class="container">
		<h1>사용할 포인트를 입력하세요.</h1>
		<hr />

		<form action="/ManyManiMVC/DoUsePoint" method="post">
			사용할 포인트 : <input type="text" name="point" /> <br /> 
		</form>
	<c:out value="${TryBookModel}"></c:out>
	</div>



</body>
</html>
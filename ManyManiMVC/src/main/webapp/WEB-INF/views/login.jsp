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

<title>Login</title>
</head>
<body>
	<!---------------------------------�׺���̼� �� ����-------------------------  -->

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="http://localhost:8080/ManyManiMVC/#">ManyManiSystem</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="http://localhost:8080/ManyManiMVC">Home</a></li>
      <li><a href="/ManyManiMVC/borrowBook">�뿩�ϱ�</a></li>
      <li><a href="/ManyManiMVC/returnBook">�ݳ��ϱ�</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
  <!--     <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li> -->
      <li><a href="/ManyManiMVC/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
 

	<div class="container">
		<h2>�α��� Form ȭ�� - ���̵�, �н����� �Է�</h2>
		<hr />

		<form action="/Day16/j03_login02_DB.jsp" method="post">
			���̵� : <input type="text" name="id" /> <br /> �н����� : <input
				type="text" name="pw" /> <br /> <input type="submit" value="�α����ϱ�" />
		</form>

	</div>

</body>
</html>
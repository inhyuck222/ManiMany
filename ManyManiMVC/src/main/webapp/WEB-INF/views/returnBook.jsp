<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
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

<%@ page session="true"%>

<title>Return Page</title>
</head>
<body>

	<!---------------------------------�׺���̼� �� ����-------------------------  -->
	<jsp:include page="topMenu.jsp" flush="false"></jsp:include>
	<!---------------------------------�׺���̼� �� ��-------------------------  -->

	<%-- <%
		String rcv = (String) session.getAttribute("returnfail");
		if (rcv.equals("�ݳ�����")) {
	%>

	<script type="text/javascript">
		alert("�ݳ��� �����Ͽ����ϴ�. �ٽ� �ݳ����ּ���");
		location.href = "/ManyManiMVC/";
	</script>

	<%
		}else{
	%>
	
	
	<%
	
		}
	%>
 --%>


	<div class="container">
		<h1>�ݳ��Ͻ� å ��ȣ�� �Է��ϼ���.</h1>
		<hr />

		<form action="/ManyManiMVC/DoReturnBook" method="post">
			�ݳ��� å��ȣ : <input type="text" name="booknumber" /> <br />
		</form>

	</div>



</body>
</html>
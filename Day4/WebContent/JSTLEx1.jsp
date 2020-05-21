<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <table border="1">
	<c:forEach  begin="1" end="10" var="i" step="3">
		<tr>
			<td>${i}</td>
		</tr>
	</c:forEach>
	</table> --%>
	
<table border="1">
	<c:forEach items="${header}" var="i">
		<tr>
			<td>${i.value} </td>
		</tr>
	</c:forEach>
	</table>
	
	<c:set var="a" value="10"/>
	<c:set var="b" value="20"/>
	a + b = ${a+b} <br>  
	<c:out value="${b}"></c:out>
</body>
</html>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<f:formatNumber var="num" value="${1234567.890}" maxFractionDigits="1"/> 
	<f:formatDate var="date" value="<%=new Date() %>" pattern="yyyy-MM-dd HH:mm:ss" />
	${date} <br>
	${num }
</body>
</html>
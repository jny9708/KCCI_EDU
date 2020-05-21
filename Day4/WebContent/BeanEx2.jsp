<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="dept" class = "day4.ooad.MyBean" scope="session"/>
	<jsp:setProperty property="*" name="dept" 	/>
	<jsp:getProperty property="info" name="dept" />
</body>
</html>
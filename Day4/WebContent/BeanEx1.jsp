<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="dept" class = "day4.ooad.MyBean" scope="page"/>
	<jsp:setProperty property="id" name="dept" value="10"/>
	<jsp:setProperty property="deptName" name="dept" value="총무팀"/>
	<jsp:setProperty property="locId" name="dept" value="200"/>
	
	<jsp:getProperty property="info" name="dept" />
	
</body>
</html>
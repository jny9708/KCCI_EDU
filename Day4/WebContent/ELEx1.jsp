<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${ 4 + 7 }<br>
	header : ${ header }<br>
	cookie : ${ cookie }<br>
	${ header["accept"] }<br>
	${ header.host } <br>
	쿼리스트링: ${param.id} , ${param.deptName} <br>
</body>
</html>
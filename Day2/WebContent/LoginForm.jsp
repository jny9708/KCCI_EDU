<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String loginId = (String)request.getAttribute("loginId");
    	String checked = (String)request.getAttribute("checked");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>시스템 로그인</title>
</head>
<body>
	<form action="/Login" method="post">
		아이디: <input type="text" name="id" value="<%=loginId%>"/><br>
		비밀번호: <input type="password" name="password"/><br>
		<input type="checkbox" name="saveLoginId" <%=checked %>>아이디 저장<br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>
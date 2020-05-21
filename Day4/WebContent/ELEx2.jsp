<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	
	// 같은이름으로 선언하면 우선순위는 더 작은 범위의 범위가 더 우선순위가 높다
	pageContext.setAttribute("MyValue", 500);
	request.setAttribute("MyValue", 100);
	request.getSession().setAttribute("MyValue", 50);
	request.getServletContext().setAttribute("MyValue", 0);
	%>
	
	세션 MyValue = ${sessionScope.MyValue}<br> 
	어플리케이션 MyValue = ${applicationScope.MyValue} 
</body>
</html>
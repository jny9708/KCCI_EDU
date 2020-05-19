<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%! int value = 1; 
    	private int sum(int v1, int v2) {return v1+v2;}
    %>
    <% 
    value++;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%= value %>
<%=sum(20,20) %>
</body>
</html>
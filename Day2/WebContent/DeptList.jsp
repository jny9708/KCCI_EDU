<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="day2.entity.Dept"%>
    
<!DOCTYPE html>
<%  ArrayList<Dept> deptList = (ArrayList<Dept>)request.getAttribute("deptList"); %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	for(Dept d : deptList){
		out.println(d.getId() + " : " + d.getDeptName());
%>
	<a href="DeptDelete?id=<%=d.getId()%>"> 삭제 </a>
<% 
		out.println("<br>");
		out.println("-----------------------------<br>");
	} 
%>
<a >추가</a>
</body>
</html>
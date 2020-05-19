<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%--  <%!
    	private void times(HttpServletResponse response) throws Exception{
    	PrintWriter out = response.getWriter();
	    	for(int i =2; i<=9; i++){
	    		for(int j =1; j<=9; j++){
	    			out.println(i + " * " + j + " = "+ (i * j));
	    			out.println("<br>");
	    		}
	    		out.println("-----------------------------");
	    	}
    	}
    %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
	for(int i =2; i<=9; i++){
	    		for(int j =1; j<=9; j++){
	    			out.println(i + " * " + j + " = "+ (i * j));
	    			out.println("<br>");
	    		}
	    		out.println("-----------------------------<br>");
	    	}
	%>
	<%-- <%=times(response)%> --%>
</body>
</html>
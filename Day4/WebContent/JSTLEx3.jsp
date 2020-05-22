<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<sql:setDataSource 
var="ds" driver="oracle.jdbc.driver.OracleDriver"
url="jdbc:oracle:thin:@localhost:1521:xe" user="scott" password="tiger"
 />
 
 <sql:query var="rs" dataSource="${ds}" >
 	select * from dept 
 	
 </sql:query>

<sql:update var="num" dataSource="${ds}">
	update dept set loc_id = 1000 where id= ?
	<sql:param  value="${10 }"/>
</sql:update>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
적용된 행의 갯수 : ${num}개 <br>
<c:forEach var="dept" items="${rs.rows}">
		${dept.id },${dept.dept_name } , ${dept.loc_id }<br>
	</c:forEach>   
</body>
</html>
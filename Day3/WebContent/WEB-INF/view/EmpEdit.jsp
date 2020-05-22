<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>사번</td>
			<td><input type="text" name="empNo" value="${emp.empNo}"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" value="${emp.name}"></td>
		</tr>
		<tr>
			<td>급여</td>
			<td><input type="text" name="salary" value="${emp.salary}"></td>
		</tr>
		<tr>
			<td>부서</td>
			<td>
				<input type="text" name="deptId" value="${emp.deptId}">
			</td>
		</tr>
		
		<tr>
			<td>부서</td>
			<td>
				<select>
					
					<option value="0">부서 없음</option>
					<c:forEach items="${deptList}" var="d">
						<c:set var="selected" value=""/>
						<c:if test="${emp.deptId == d.id }">
							<c:set var="selected" value="selected"/>
						</c:if>
						<option value="${d.id}" ${selected} >${d.deptName}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
				
	</table>
</body>
</html>
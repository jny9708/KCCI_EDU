<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function checkFields() {
	}
</script>
</head>
<body>
<form action="FrontController?action=EmpEdit" method=post onsubmit="return checkFields()">
<table border="1">
	<tr>
		<td width="100">사 번</td>
		<td><input type="text" name="id" value="${emp.id}"></td>
	</tr>
	<tr>
		<td width="100">이 름</td>
		<td><input type="text" name="name" value="${emp.name}"></td>
	</tr>
	<tr>
		<td width="100">부 서</td>
		<td>
			<select name="deptId">
				<c:forEach var="dept" items="${depts}">
					<c:set var="select" value=""/>
					<c:if test="${emp.dept.id == dept.id}">
						<c:set var="select" value="selected"></c:set>
					</c:if>
					<option value="${dept.id}" ${select}>${dept.deptName}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td width="100">전화번호</td>
		<td><input type="text" name="phoneNo" value="${emp.phoneNo}"></td>
	</tr>
	<tr>
		<td width="100">이메일</td>
		<td><input type="text" name="email" value="${emp.email}"></td>
	</tr>
	<tr>
		<td width="100">입사일</td>
		<td><input type="text" name="hireDate" value="${emp.hireDate}"></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="수 정">
			<input type="button" value="취 소" onclick="location.href='FrontController?action=EmpList'">
		</td>
	</tr>
</table>
</form>
</body>
</html>
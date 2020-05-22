<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
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
<form action="FrontController?action=EmpAdd" method=post onsubmit="return checkFields()">
<table border="1">
	<tr>
		<td width="100">사 번</td>
		<td><input type="text" name="id"></td>
	</tr>
	<tr>
		<td width="100">이 름</td>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
		<td width="100">부 서</td>
		<td>
			<select name="deptId">
				<c:forEach var="dept" items="${depts}">
					<option value="${dept.id}">${dept.deptName}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td width="100">전화번호</td>
		<td><input type="text" name="phoneNo"></td>
	</tr>
	<tr>
		<td width="100">이메일</td>
		<td><input type="text" name="email"></td>
	</tr>
	<tr>
		<td width="100">입사일</td>
		<td><input type="text" name="hireDate"></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="추 가">
			<input type="button" value="취 소" onclick="location.href='EmpList'">
		</td>
	</tr>
</table>
</form>
</body>
</html>
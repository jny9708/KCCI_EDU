<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	table.list {
		border: thin solid black;
	}

</style>
<script type="text/javascript">
	function goEdit(id) {
		empForm.action = "FrontController?action=EmpEditForm";
		empForm.id.value = id;
		empForm.submit();							
	}
	
	function goDelete(id) {
		if (confirm('정말로 삭제하시겠습니까?')) {
			empForm.action = "FrontController?action=EmpDelete";
			empForm.id.value = id;
			empForm.submit();						
		}
	}
</script>
</head>
<body>
<form name="empForm" method="post">
<input type="hidden" name="id" border="1">
<a href="FrontController?action=EmpAddForm">직원 추가</a>
<table class="list">
<tr align="center" style="background-color:lightblue;color:#EEEE">
	<th class="a" width="80">사번</th>
	<th width="100">이름</th>
	<th width="100">부서명</th>
	<th width="100">전화번호</th>
	<th width="60">수정</th>
	<th width="60">삭제</th>
</tr>
<c:forEach var="emp" items="${emps}">
<tr>
	<td align="center">${emp.id}</td>
	<td>${emp.name}</td>
	<td>${emp.dept.deptName}</td>
	<td>${emp.phoneNo}</td>
	<td align="center"><input type="button" value="수정" onclick="goEdit(${emp.id})"></td>
	<td align="center"><input type="button" value="삭제" onclick="goDelete(${emp.id})"></td>
</tr>
</c:forEach>
</table>
</form>
</body>
</html>
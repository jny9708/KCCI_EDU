<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--     <%@page import="day3.model.entity.Dept"%> --%>
<!DOCTYPE html>
<%-- <% Dept dept = (Dept)request.getParameter("dept"); %> --%>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <title>부서 추가</title>
  </head>
  <body>
	<div class="container">
		<h3>부서 추가</h3>
		<hr>
		<form action="DeptEdit" method="post">
			<div class="form-group form-inline">
				<div class="col-form-label col-2">부서아이디 : </div> 
				<input  name="id" class=" form-control col-10" type="text"  value="${dept.id}" readonly> 
			</div>
			
			<div class="form-group form-inline">  
				<div class="col-form-label col-2">부서명 : </div> 
				<input class="form-control col-10" type="text" name="deptName" value="${dept.deptName}" >
			</div>
			
			<div class="form-group form-inline" >  
				<div class="col-form-label col-2">지역코드 : </div> 
				<input class="form-control col-10" type="text" name="locId" value="${dept.locId}" >
			</div> 
			 
			<div class="form-group">
				<button type="submit" class="btn btn-success"> 수정 </button> &nbsp;
				<a class="btn btn-primary" href="DeptList"> 목록 </a>
			</div>
		</form> 
	</div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
  </body>
</html>
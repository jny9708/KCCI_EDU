<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="day3.model.entity.Dept"%>
<!DOCTYPE html>
<%  ArrayList<Dept> deptList = (ArrayList<Dept>)request.getAttribute("deptList"); %>
<html>
<head>

 <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <title>부서 목록</title>
  </head>
  <body>
  <div class="container-fluid">
    <h4>부서 목록 </h4>
    <a class="btn btn-success" href="DeptAdd"> 추가 </a>
    <table class="table table-striped table-hover">
    	<thead>
    		<tr>
	    		<th scope="col">부서ID</th>
	    		<th scope="col">부서명</th>
	    		<th>부서 코드</th>
	    		<th></th>
    		</tr>
    	</thead>
    	
    	<tbody>
    	<%
	for(Dept d : deptList){
	%>
    		<tr>
	    		<th scope="row"><%=d.getId()%></td>
	    		<td><%=d.getDeptName()%></td>
	    		<td><%=d.getLocId()%></td>
	    		<td>
	    			<a class="btn btn-primary" href="DeptEdit?id=<%=d.getId()%>"> 수정 </a>
	    			<a class="btn btn-primary" href="DeptDelete?id=<%=d.getId()%>"> 삭제 </a>
				</td>
    		</tr>
    	<% 	
    		} 
		%>
    	</tbody>
    	
    	
    </table>
    </div>
    <%-- <%
	for(Dept d : deptList){
		out.println(d.getId() + " : " + d.getDeptName() + "," + d.getLocId());
		out.println("<br>");
		out.println("-----------------------------<br>");
	} 
	%> --%>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
  </body>
</html>
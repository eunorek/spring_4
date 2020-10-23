<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootstrap.jsp"></c:import>
</head>

<body>
<c:import url="../template/header.jsp"></c:import> 
<div class="container">
	<h3>Member Page</h3>
	<table class="table table-condensed">
		<tr>
			<th>ID: </th>
			<td>${member.id}</td>
		</tr>
		<tr>
			<th>이름: </th>
			<td>${member.name}</td>
		</tr>		
		<tr>
			<th>Email: </th>
			<td>${member.email}</td>
		</tr>		
	</table>
	<a href="./memberUpdate" class="btn btn-info" role="button">수정</a>
	<a href="./memberDelete" class="btn btn-danger" role="button">회원 탈퇴</a>	
	
	
</div>
</body>
</html>
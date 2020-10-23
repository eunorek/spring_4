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
	 	<form action="./memberJoin" method="post">
		    <div class="form-group">
		      <label for="id">ID:</label>
		      <input type="text" class="form-control" id="id" placeholder="아이디를 설정하세요" name="id">

		    </div>	 
		  	<div class="form-group">
		      <label for="pw">패스워드:</label>
		      <input type="password" class="form-control" id="pw" placeholder="비밀번호를 설정하세요" name="pw">
		   	</div>
		  	<div class="form-group">
		      <label for="pw">패스워드 재입력:</label>
		      <input type="password" class="form-control" id="pw-re" placeholder="비밀번호를 다시 입하세요">
		   	</div>		
		  	<div class="form-group">
		      <label for="name">이름:</label>
		      <input type="text" class="form-control" id="name" placeholder="이름을 입력하세요" name="name">
		   	</div>	
		  	<div class="form-group">
		      <label for="email">이메일 주소:</label>
		      <input type="text" class="form-control" id="email" placeholder="이메일 주소를 입력하세요" name="email">
		   	</div>	
		   	<input type="submit" class="btn btn-success" value="회원 가입하기">		   		   			   		
	 	</form>
	 </div>
</body>
</html>
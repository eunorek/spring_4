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
	<h3>Member Login</h3>
	<form action="./memberLogin" method="post">
	  <div class="form-group">
	    <label for="id">ID:</label>
	    <input type="text" class="form-control" id="id" name="id" value="${cookie.remember.value}">
	  </div>
	  <div class="form-group">
	    <label for="pw">Password:</label>
	    <input type="password" class="form-control" id="pw" name="pw">
	  </div>
	  <div class="checkbox">
	    <label><input type="checkbox" name="remember" id="remember"> Remember me</label>
	  </div>
	  <button type="submit" class="btn btn-default">Submit</button>
	</form>	
	<a type="button" href="./memberJoin" class="btn btn-primary">회원가입</a>	
</div>
<script type="text/javascript">
	if(${cookie.remember != null}){
		$("#remember").attr("checked", true)
	}
</script>
</body>
</html>
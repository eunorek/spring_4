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
	  <h2>${board} Reply Form</h2>
	  <form action="./qnaReply" method="post" id="frm">
	  	<!-- 부모 num 넘겨주기 용 hidden input -->
	  	<input type="hidden" name="num" value="${dto.num }"/>
	    <div class="form-group">
	      <label for="title">Title:</label>
	      <input type="text" class="form-control" id="title" placeholder="Enter Title" name="title">
	    </div>
	    
	    <div class="form-group">
	      <label for="writer">Writer:</label>
	      <input type="text" class="form-control" id="writer" placeholder="Enter Writer" name="writer">
	    </div>	    

	    <div class="form-group">
	      <label for="contents">Contents:</label>
	      <textarea class="form-control" rows="10" id="contents" name="contents"></textarea>
	    </div>
	    <!-- submit button -->
	    <input type="button" value="write" class="btn btn-primary" id="btn"/>
	  </form>
	</div>
	<!-- title, writer 미기재 방지 -->
	<script type="text/javascript" src="../resources/js/boardWrite.js"></script>
</body>
</html>
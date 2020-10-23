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
	  <h2>${board} Write Form</h2>
	  <form action="./Write" method="post" id="frm">
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
	    <c:if test="${not empty member}">
	    	<input type="button" value="write" class="btn btn-primary" id="btn"/>
	    </c:if>	    
	  </form>
	</div>
	<script type="text/javascript" src="../resources/js/boardWrite.js"></script>
	<script type="text/javascript">
		if(${board == 'qna'}){
			$("#writer").val("${member.id}")
			$("#writer").setAttribute("readonly", "readonly")
		}
		

	</script>
</body>
</html>
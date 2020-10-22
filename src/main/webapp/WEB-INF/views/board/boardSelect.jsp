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
	<div>
		<h3>${board} Select Page</h3>
		<h3 id="num">${dto.num }</h3>
		<h3>Title	: ${dto.title }</h3>
		<h3>Writer	: ${dto.writer }</h3>
		<h3>Content	: ${dto.contents }</h3>
		<input type="button" value="Delete" class="btn btn-danger" id="del" title="${dto.num}" />
		<input type="button" value="Update" class="btn btn-primary" id="update" />
		<c:if test="${board == ''}">
		</c:if>
		<input type="button" value="Reply" class="btn btn-secondary" id="reply" title="${dto.num}"/>
	</div>
	<script type="text/javascript">
		$("#del").click(function(){
			var num = $("#del").attr("title")
			location.href="./qnaDelete?num=" + num
		})
		
		$("#update").click(function(){
			location.href = "./qnaUpdate?num=${dto.num}"
		})
		
		$("#reply").click(function(){
			location.href = "./qnaReply?num=${dto.num}"
		})
	</script>
</body>
</html>
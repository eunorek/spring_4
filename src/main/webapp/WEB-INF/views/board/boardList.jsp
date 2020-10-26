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
	<h1>${board} List</h1>
	<div class="row">
		<div class="col-sm-8">
		<form action="./${board}List" id="searchForm">
			<input type="hidden" name="curPage" id="curPage"/>
			<div class="input-group">
				<select class="input-group-sm" id="kind" name="kind">
					<option value="tt">Title</option>
					<option value="wr">Writer</option>
					<option value="con">Contents</option>
				</select>
				<input id="search" type="text" class="form-control" name="search" placeholder="Additional Info">
					<div class="input-group-btn">
						<button class="btn btn-default" type="submit">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</div>
			</div>
				</form>
		</div>
	</div>

	<table>
		<tr>
			<td>글 번호</td>
			<td>글 제목</td>
			<td>작성자</td>
			<td>내용</td>
			<td>작성일</td>
			<td>조회수</td>
		</tr>
		<c:forEach items="${list}" var="dto" varStatus="vs">
			<tr>
				<td>${dto.num}</td>
				<td>				
					<a href="./${board}Select?num=${dto.num}">
					<c:catch>
						<c:forEach begin="1" end="${dto.depth}">--</c:forEach>
					</c:catch>
					${dto.title}
					</a>				
				</td>
				<td>${dto.writer}</td>
				<td>${dto.contents}</td>
				<td>${dto.regDate}</td>
				<td>${dto.hit}</td>
			</tr>
		</c:forEach>
	</table>	
	<div>
		<c:if test = "${pager.prevCheck}">
			<span class="c1" title="${pager.startPage-1 }">◄ 이전</span>
		</c:if>		
		<c:forEach begin="${pager.startPage}" end="${pager.lastPage}" var="i">
			<span class="c1" title="${i}">${i}</span>
		</c:forEach>	
		<c:if test = "${pager.nextCheck}">
			<span class="c1" title="${pager.lastPage+1 }">다음 ►</span>
		</c:if>			
	</div>
	<a href="./${board}Write" class="btn btn-warning btn-lg" role="button" id="btn-write" style="visibility: hidden">Write</a>
</div>	
</body>

<script type="text/javascript">
	var kind = '${pager.kind}'
	var search = "${pager.search}"		
	if(kind.length < 1){
		kind = "tt"}

	$("#kind").val(kind)
	$("#search").val(search)
	
	$(".c1").click(function(){
		var c = $(this).attr("title")
		var kind = '${pager.kind}'
		var search = "${pager.search}"
		$("#curPage").val(c)
		$("#kind").val(kind)
		$("#search").val(search)
		$("#searchForm").submit()
	})
	
	if(${empty member}){	
	}else if(${board == 'qna' || member.id == 'admin'}){
		$("#btn-write").css("visibility", "visible")
	}
</script>
</html>
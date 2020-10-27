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
<style type="text/css">
table{
	border: 3px gray solid;
	width: 100%;
}
</style>

</head>

<body>
<c:import url="../template/header.jsp"></c:import> 

<div class="container">
	<h1>Memo Page</h1>
	
	    <div class="form-group">
	      <label for="writer">Writer:</label>
	      <input type="text" class="form-control" id="writer" placeholder="Enter Writer" name="writer">
	    </div>	    

	    <div class="form-group">
	      <label for="contents">Contents:</label>
	      <textarea class="form-control" rows="10" id="contents" name="contents"></textarea>
	    </div>	
	    <input type="button" value="write" class="btn btn-primary" id="btn-write"/>
		<div>
			<table class="table table-hover" >
				<thead>
					<tr>
						<th>Number</th>
						<th>Writer</th>
						<th>Contents</th>
						<th>Date</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody id="result">
				</tbody>
			</table>
		</div>	
		<button class="btn btn-danger" id="more">More</button>
	</div>


<script type="text/javascript">
	var curPage = 1
	getList()
	
/* 	function getList(){
		$.get("./memoList", function(data){
			$("#result").html(data)
		})
	} */
	
	function getList(){
		$.ajax({
			url : "./memoList",
			type : "GET",
			data : {curPage:curPage},
			success : function(data){
				$("#result").append(data)
				}
			})
	}
	
	// ********** MORE ************	
	$("#more").click(function(){
		curPage++
		getList()
	})
	
	
/* 	// ********** INSERT ************
	$("#btn-write").click(function(){
		var writer = $("#writer").val()
		var contents = $("#contents").val()
		$.post("./memoWrite", {writer:writer, contents:contents}, function(result){
			alert(result)
			$("#writer").val("")
			$("#contents").val("")
			$("#result").empty()
			getList()
		})
	})
	
	// ********** DELETE ************	
	$("#result").on("click", ".del", function(){
		var num = $(this).attr("id")
		$.post("./memoDelete", {num:num}, function(message){
			message = message.trim()
			if(message == "1"){
				alert("delete success")
				$("#result").empty()
				getList()		
			}else{
				alert("delete fail")
			}
			
		})
	}) */
	
	// ********** INSERT AJAX ************
	$("#btn-write").click(function(){
		var writer = $("#writer").val()
		var contents = $("#contents").val()
		$.ajax({
			url : "./memoWrite",
			type : "POST",
			data : {writer:writer, contents:contents},
			success : function(result){
				result = result.trim()
				var message = "글이 등록되었습니다."
				$("#writer").val("")
				$("#contents").val("")
				$("#result").empty()
				curPage = 1
				alert(message)
				getList()
			}
			
		})
	})
	
	// ********** DELETE AJAX ************	
	$("#result").on("click", ".del", function(){
		var num = $(this).attr("id")
		$.ajax({
			url : "./memoDelete",
			type : "POST",
			data : {num : num},
			success : function(result){
				result = result.trim()
				var message = "글이 삭제되었습니다."
				if(result.length > 0){
					$("#result").empty()
					curPage = 1					
					getList()
				}else{
					message = "오류: 삭제에 실패했습니다."	
				}
				alert(message)
			}
		})		
		
	})
	


</script>
</body>
</html>
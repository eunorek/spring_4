<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootstrap.jsp"></c:import>
<style type="text/css">
#files-container{
	margin: 10px auto;
}

.input-group{
	border: 1px gray solid;
	margin-bottom: 2px;
}

.del {
	color: red;
	font-weight: bold;
	cursor: pointer;
}

.attatched-file{
	vertical-align: middle;
}

</style>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>

	<div class="container">
		<h2>${board} Write Form</h2>
		<form action="./${board}Write" method="post" id="frm" enctype="multipart/form-data">
			<div class="form-group">
				<label for="title">Title:</label> <input type="text"
					class="form-control" id="title" placeholder="Enter Title"
					name="title">
			</div>

			<div class="form-group">
				<label for="writer">Writer:</label> <input type="text"
					class="form-control" id="writer" placeholder="Enter Writer"
					name="writer">
			</div>

			<div class="form-group">
				<label for="contents">Contents:</label>
				<textarea class="form-control" rows="10" id="contents"
					name="contents"></textarea>
			</div>

			<input type="button" value="FileAdd" class="btn btn-info"
				id="file-add" /> 
			<label for="files">File:</label>
			<!-- 첨부파일들 -->
			<div id="files">
				<div id="files-container">
				</div>
			</div>
			<c:if test="${not empty member}">
				<input type="submit" value="write" class="btn btn-primary"
					id="btn-write" style="visibility: hidden" />
			</c:if>
		</form>
	</div>
	<script type="text/javascript" src="../resources/js/boardWrite.js"></script>
	<script type="text/javascript">
		var fileCount = 0
		var maxFileUpload = 5	
	
		if(${empty member}){	
		}else if(${board == 'qna' || member.id == 'admin'}){
			$("#btn-write").css("visibility", "visible")
		}
		
		var fileTag = `
			<div class="input-group">
				<input type="file" class="attatched-file" name="files" />
				<span class="input-group-addon del">삭제</span>
			</div>`
		
		// appending a file entry
		$("#file-add").click(function(){
			if(fileCount < maxFileUpload){
				$("#files-container").append(fileTag)	
				fileCount++
			}else{
				alert("첨부파일 등록은 최대 5개까지 가능합니다")
			}		
		})
		
		// deleting a file entry clicked
		$("#files-container").on("click", ".del", function(){
			$(this).parent().remove()
			fileCount--
		})
	</script>
</body>
</html>
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
<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script type="text/javascript">

</script>

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
		<h2>${board} Update Form</h2>
		<form action="./${board}Update" method="post" id="frm" enctype="multipart/form-data">
			<div class="form-group">
				<label for="title">Title:</label> <input type="text"
					class="form-control" id="title" placeholder="Enter Title"
					name="title">
			</div>

			<div class="form-group">
				<label for="writer">Writer:</label> <input type="text"
					class="form-control" id="writer" value="${dto.writer}" readonly="readonly"
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

		$('#contents').summernote({
			height:300;
		});
	
		if(${empty member}){	
		}else if(${board == 'qna' || member.id == 'admin'}){
			$("#btn-write").css("visibility", "visible")
		}
	</script>
</body>
</html>
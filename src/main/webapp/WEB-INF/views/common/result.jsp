<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	var result = "${message}"
	var path = "${path}"
	alert(result)
	// 현 페이지 url은 noticeDelete  
	location.href = path
</script>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
<c:import url="./template/bootstrap.jsp"></c:import>
</head>
<body>
<c:import url="./template/header.jsp"></c:import>

	<div>
		<c:if test="${not empty member}">
			<h1>Login Success</h1>
		</c:if>
		<c:if test="${empty member}">
			<h1>Login Fail</h1>
		</c:if>				
		<img alt="main image" src="./resources/images/index/image_01.jpg">
	</div>
	<a href="./cookie/makeCookie">Cookie</a>
</body>
</html>

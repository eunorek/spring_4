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
	.check-valid{
		color: green;
	}
	
	.check-invalid{
		color: red;
	}

	.validity-check-msg{
		height: 20px;
		/* border: 1px red solid;*/
		margin: 5px auto;
	}
	
	.form-group{
		margin: 10px auto;
	}
	
</style>

</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<div class="container">
		<form id="form-submit" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="id">ID:</label> 
				<input type="text" class="form-control"
					id="id" placeholder="아이디를 설정하세요" name="id">
				<div id="id-check" class="validity-check-msg"></div>
			</div>
			<div>
				<div class="form-group">
					<label for="pw">패스워드:</label> <input type="password"
						class="form-control" id="pw" placeholder="비밀번호를 설정하세요" name="pw">
				</div>
				<div class="form-group">
					<label for="pw">패스워드 재입력:</label> <input type="password"
						class="form-control" id="pw-re" placeholder="비밀번호를 다시 입하세요">
				</div>
				<div id="pw-check" class="validity-check-msg"></div>
			</div>
			<div class="form-group">
				<label for="name">이름:</label> <input type="text"
					class="form-control" id="name" placeholder="이름을 입력하세요" name="name">
				<div id="name-check" class="validity-check-msg"></div>
			</div>
			<div class="form-group">
				<label for="email">이메일 주소:</label> <input type="text"
					class="form-control" id="email" placeholder="이메일 주소를 입력하세요"
					name="email">
				<div id="email-check" class="validity-check-msg"></div>
			</div>
			<div class="form-group">
				<label for="file">프로필 사진:</label> <input type="file"
					class="form-control" id="photo" name="photo">
				<div id="email-check" class="validity-check-msg"></div>
			</div>			
			<input type="submit" class="btn btn-success" value="회원 가입하기" id="btn-join">
			<button>Test Join</button>		
		</form>
	</div>
<script type="text/javascript">

	$("#btn-join").click(function(){
		emptyCheck()
		$("#form-submit").submit()
	})



//******************** EVENTS **************************






//******************** FUNCTIONS **************************
// returns check result(true or false) and modifies validity-check-msg
	// empty check
	function emptyCheck(){
		$(".form-control").each(function(){
			var data = $(this).val
			if(data.length < 1){
			$(this).next.val("필수 항목입니다!")			
		}
		})
	}
	
	// id dup check 
	function idDupCheck(){
		var id = $("#id").val()
		if(id.length < 1){
			$.ajax({
				url : "./memberIdCheck",
				type : "GET",
				data : {id : id},
				success : function(result){
					data = data.trim()
					return data
				}
			})
		}			
	}

	function pwMatchCheck(){
		
	}
	

	
	$("#id").blur(function(){
		var isDup = idDupCheck()
		if(result == 1){
			alert("이미 사용중인 아이디입니다")
		}else{
			alert("멋진 아이디네요 ;-)")
		}
	})
	
	
	//pw match check
	$("#pw-re").blur(function(){
		var pw = ("#pw")
		
	})
</script>
</body>
</html>
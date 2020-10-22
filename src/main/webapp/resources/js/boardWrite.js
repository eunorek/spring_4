/**
 * 
 */
 
$("#btn").click(function(){
	var t = $("#title").val()
	var w = $("#writer").val()
	if(t.length>0 && w.length>0){
		$("#frm").submit();
	}else{
		alert("글 제목과 작성자는 필수 입력 항목입니다");
	}
})	
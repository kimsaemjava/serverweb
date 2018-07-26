<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Insert title here</title>
	<script
	 src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
	</script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#ajaxbtn").on("click",function(){
				var querydata = {"id":$("#id").val()}
		
				$.ajax({
					url:"/serverweb/ajaxtest01",
					type:"get",
					data:querydata,
					dataType:"text",
					success:success_run,
					error:err_run
				})//속성을 셋팅할때 json표현방식으로
			});
		});
		//ajax요청이 성공하면 .ajax메소드 내부에서 success속성에 설정한 함수를 호출한다.
		//ajax의 처리 결과를 함수로 전달한다. - 자동으로 호출
		function success_run(txt){
			//alert("jquery-ajax요청 성공"+txt);
			$("#result").html("<h2>jquery:"+txt+"</h2>");
		}
		//obj - XMLHttpRequest객체, msg-응답메시지, statusMsg - 에러메시지
		function err_run(obj,msg,statusMsg){
			alert("오류발생=>"+obj+","+msg+","+statusMsg);
		}
	</script>
</head>
<body>
	<h1>Ajax테스트하기(JQuery...)</h1>
	<form name="myform">
		<input type="text" name="id" id="id"/>
		<input type="button" id="ajaxbtn" value="ajax테스트">
	</form>
	<div id="result"></div>
</body>
</html>
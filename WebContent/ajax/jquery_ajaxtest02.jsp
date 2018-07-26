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
			$.get("/serverweb/ajaxtest01",
				{"id":$("#id").val()},success_run);
		})
	})
	function success_run(txt){
		$("#result").html("get:"+txt);
	}
	</script>
</head>
<body>
	<h1>Ajax테스트하기(JQuery...get)</h1>
	<form name="myform">
		<input type="text" name="id" id="id"/>
		<input type="button" id="ajaxbtn" value="ajax테스트">
	</form>
	<div id="result"></div>
</body>
</html>
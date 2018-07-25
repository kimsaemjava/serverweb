<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Insert title here</title>
	<script type="text/javascript">
		function runAjax(){
			var xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function(){
				if(xhr.readyState==4 && xhr.status==200){
					document.getElementById("result").innerHTML 
						= xhr.responseText; 
				}
			}
			xhr.open("POST","/serverweb/ajaxgugu_post",true);
			xhr.setRequestHeader("Content-type",
					"application/x-www-form-urlencoded")
			xhr.send("num="+myform.num.value);
		}
	
	</script>
</head>
<body>
	<h1>Ajax테스트-post</h1>
	<form name="myform">
		숫자입력하기(2~9)
		<input type="text" name="num">
		<input type="button" onclick="runAjax()" value="구구단출력"/>	
	</form>
	<div id="result"></div>
</body>
</html>
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
			xhr.open("GET","/serverweb/ajaxgugu?num="+myform.num.value,
								true);
			xhr.send();
		}
	
	</script>
</head>
<body>
	<h1>Ajax�׽�Ʈ</h1>
	<form name="myform">
		�����Է��ϱ�(2~9)
		<input type="text" name="num">
		<input type="button" onclick="runAjax()" value="���������"/>	
	</form>
	<div id="result"></div>
</body>
</html>
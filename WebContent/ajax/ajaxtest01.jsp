<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Insert title here</title>
	<script type="text/javascript">
		function runAjax(){
			//2. 비동기통신을 할 수 있는 자바스크립트 객체를 생성 - XMLHttpRequest
			var xhr = new XMLHttpRequest();
			//7. 응답이 오는 경우 어떻게 처리를 할 것인지 에 대한 콜백함수 구현을 한다.
			xhr.onreadystatechange = function(){
				/* alert("상태값:"+xhr.readyState); */
				if(xhr.readyState==4 && xhr.status==200){//정상처리
					//responseText가 ajax실행 결과인 응답데이터
					//alert(xhr.responseText);
					document.getElementById("result").innerHTML 
							= xhr.responseText;
				}
			}		
			
			//3. 요청을 설정
			xhr.open("GET","/serverweb/ajaxtest01?id="
					+myform.id.value,true);
			//4. 요청보내기
			xhr.send();//get방식인 경우
		}
	</script>
</head>
<body>
	<h1>Ajax테스트하기</h1>
	<form name="myform">
		<input type="text" name="id"/>
		<!-- 1. 버튼을 누르면 자바스크립트 함수를 호출하며 요청을 보낸다. -->
		<input type="button" onclick="runAjax()" value="ajax테스트">
	</form>
	<div id="result"></div>
</body>
</html>
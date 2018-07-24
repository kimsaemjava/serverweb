<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Insert title here</title>
</head>
<body>
	<h1>부서정보출력하기 - json을 텍스트형태로 전달받은 경우</h1>
	<div id="dept_eval"></div>
	<div id="dept_parser"></div>
	<script type="text/javascript">
		var deptlist = '{"dept":' 
				+'[{"code":"001","name":"정보시스템팀","loc":"4층"},'
				+'{"code":"002","name":"시스템지원팀","loc":"7층"},'
				+'{"code":"003","name":"기업영업팀","loc":"6층"},'
				+'{"code":"004","name":"전산실","loc":"5층"}'
				+']'	
				+ '}';
		//텍스트의 형태로 json이 전달되는 경우 자바스크립트에서 사용하려면 	텍스트를 json객체로
		//변환하는 작업을 해야 한다. - 파싱
		
		//eval함수를 이용해서 json을 실행
		var obj1 = eval("("+deptlist+")");
		mydata1 = obj1.dept[0].code+","+obj1.dept[0].name
	    alert(mydata1);
		document.getElementById("dept_eval").innerHTML = mydata1;
		
		//JSON파서의 parse()를 이용
		var obj2 = JSON.parse(deptlist);
		mydata2 = obj2.dept[1].code+","+obj2.dept[1].name
	    alert(mydata2);
		document.getElementById("dept_parser").innerHTML
								= mydata2;
	</script>
</body>
</html>















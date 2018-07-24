<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		//자바스크립트 객체 선언
		var person = {
				name:"김서연",
				age:"25",
				subject:["자바","하둡","시큐어코딩"],
				addr:{
					zip:"111-222",
					addr1:"인천시"
				},
				history:[
				 	{
				 		subject:"java",
				 		month:"11"
				 	}   ,
				 	{
				 		subject:"servlet",
				 		month:"12"
				 	}   
				]			
		}
		//alert(person);
		document.write("<h3>name:"+person.name+"</h3>")
		document.write("<h3>age:"+person.age+"</h3>")
		document.write("<h3>subject:"+person.subject[0]+"</h3>")
		document.write("<h3>addr:"+person.addr.addr1+"</h3>")
		document.write("<h3>history:"
				+person.history[1].subject+"</h3>")
	</script>
</body>
</html>












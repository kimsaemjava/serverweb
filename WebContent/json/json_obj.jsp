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
		//�ڹٽ�ũ��Ʈ ��ü ����
		var person = {
				name:"�輭��",
				age:"25",
				subject:["�ڹ�","�ϵ�","��ť���ڵ�"],
				addr:{
					zip:"111-222",
					addr1:"��õ��"
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












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
				})//�Ӽ��� �����Ҷ� jsonǥ���������
			});
		});
		//ajax��û�� �����ϸ� .ajax�޼ҵ� ���ο��� success�Ӽ��� ������ �Լ��� ȣ���Ѵ�.
		//ajax�� ó�� ����� �Լ��� �����Ѵ�. - �ڵ����� ȣ��
		function success_run(txt){
			//alert("jquery-ajax��û ����"+txt);
			$("#result").html("<h2>jquery:"+txt+"</h2>");
		}
		//obj - XMLHttpRequest��ü, msg-����޽���, statusMsg - �����޽���
		function err_run(obj,msg,statusMsg){
			alert("�����߻�=>"+obj+","+msg+","+statusMsg);
		}
	</script>
</head>
<body>
	<h1>Ajax�׽�Ʈ�ϱ�(JQuery...)</h1>
	<form name="myform">
		<input type="text" name="id" id="id"/>
		<input type="button" id="ajaxbtn" value="ajax�׽�Ʈ">
	</form>
	<div id="result"></div>
</body>
</html>
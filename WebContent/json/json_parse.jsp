<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Insert title here</title>
</head>
<body>
	<h1>�μ���������ϱ� - json�� �ؽ�Ʈ���·� ���޹��� ���</h1>
	<div id="dept_eval"></div>
	<div id="dept_parser"></div>
	<script type="text/javascript">
		var deptlist = '{"dept":' 
				+'[{"code":"001","name":"�����ý�����","loc":"4��"},'
				+'{"code":"002","name":"�ý���������","loc":"7��"},'
				+'{"code":"003","name":"���������","loc":"6��"},'
				+'{"code":"004","name":"�����","loc":"5��"}'
				+']'	
				+ '}';
		//�ؽ�Ʈ�� ���·� json�� ���޵Ǵ� ��� �ڹٽ�ũ��Ʈ���� ����Ϸ��� 	�ؽ�Ʈ�� json��ü��
		//��ȯ�ϴ� �۾��� �ؾ� �Ѵ�. - �Ľ�
		
		//eval�Լ��� �̿��ؼ� json�� ����
		var obj1 = eval("("+deptlist+")");
		mydata1 = obj1.dept[0].code+","+obj1.dept[0].name
	    alert(mydata1);
		document.getElementById("dept_eval").innerHTML = mydata1;
		
		//JSON�ļ��� parse()�� �̿�
		var obj2 = JSON.parse(deptlist);
		mydata2 = obj2.dept[1].code+","+obj2.dept[1].name
	    alert(mydata2);
		document.getElementById("dept_parser").innerHTML
								= mydata2;
	</script>
</body>
</html>















<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%-- ���Ͼ��ε带 �� ���� � ���̺귯���� ������ ������� ������ method�� post�� ó���ϰ�
	   enctype="multipart/form-data"�� �����ؾ� �Ѵ�.  --%>
	<form  method="post" action="/serverweb/upload.do"
				enctype="multipart/form-data">
		�ۼ���:<input type="text" name="user"/><br/>
		����:<input type="text" name="title"/><br/>
		���ϼ���1:<input type="file" name="uploadFile1"/><br/>
		���ϼ���2:<input type="file" name="uploadFile2"/><br/>
		<input type="submit" value="���Ͽø���"/>
	</form>
</body>
</html>
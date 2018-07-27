<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%-- 파일업로드를 할 때는 어떤 라이브러리를 쓰는지 상관없이 무조건 method는 post로 처리하고
	   enctype="multipart/form-data"로 정의해야 한다.  --%>
	<form  method="post" action="/serverweb/upload.do"
				enctype="multipart/form-data">
		작성자:<input type="text" name="user"/><br/>
		제목:<input type="text" name="title"/><br/>
		파일선택1:<input type="file" name="uploadFile1"/><br/>
		파일선택2:<input type="file" name="uploadFile2"/><br/>
		<input type="submit" value="파일올리기"/>
	</form>
</body>
</html>
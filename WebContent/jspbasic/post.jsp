<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("euc-kr");
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String passwd = request.getParameter("passwd");
		String gender = request.getParameter("gender");
		String job = request.getParameter("job");
		String[] item = request.getParameterValues("item");%>
		
		<h2>���̵�:<%= userId %></h2>
		<h2>�н�����:<%= passwd %></h2>
		<h2>����:<%= userName %></h2>
		<h2>����:<%= gender %></h2>
		<h2>job:<%= job %></h2>
		<%
		for (int i = 0; i < item.length; i++) {%>
			<%= item[i] %>
		<%}%>
</body>
</html>










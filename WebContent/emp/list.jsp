<%@page import="emp.dto.EmpDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% ArrayList<EmpDTO> userlist = 
			(ArrayList<EmpDTO>)request.getAttribute("userlist"); 
	  EmpDTO loginUser = (EmpDTO)request.getAttribute("loginUser");			
	%>
	<%if(loginUser==null){
		response.sendRedirect("/serverweb/emp/login.jsp");
	}else{%>
		<h4><%= loginUser.getName()%>��</h4>
		<jsp:include page="search.jsp"/>
		<h1>������(jsp�� �и�)</h1>
		<hr/>
		<table border='1'>
			<tr bgColor='skyblue'>
				<th>���̵�</th><th>����</th><th>�н�����</th>
				<th>�ּ�</th><th>�Ի�����</th><th>���</th>
				<th>����Ʈ</th><th>�μ���ȣ</th><th>����</th>
			</tr>
			<%
			int size = userlist.size();
			for(int i=0;i<size;i++){
				EmpDTO user = userlist.get(i);%>
				<tr>
					<td>
					<a href="/serverweb/emp/read.do?id=<%=user.getId()%>&action=READ"><%= user.getId() %></a></td>
					<td><%= user.getName() %></td>
					<td><%= user.getPass() %></td>
					<td><%= user.getAddr() %></td>
					<td><%= user.getHiredate() %></td>
					<td><%= user.getGrade() %></td>
					<td><%= user.getPoint() %></td>
					<td><%= user.getDeptno() %></td>
					<td><a 
		href="/serverweb/emp/delete.do?id=<%=user.getId()%>">����</a></td>
				</tr>
			<%} %>
			
		</table>
	<%} %>
</body>
</html>







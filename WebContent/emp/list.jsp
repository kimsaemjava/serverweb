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
		<h4><%= loginUser.getName()%>님</h4>
		<jsp:include page="search.jsp"/>
		<h1>사원목록(jsp로 분리)</h1>
		<hr/>
		<table border='1'>
			<tr bgColor='skyblue'>
				<th>아이디</th><th>성명</th><th>패스워드</th>
				<th>주소</th><th>입사년월일</th><th>등급</th>
				<th>포인트</th><th>부서번호</th><th>삭제</th>
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
		href="/serverweb/emp/delete.do?id=<%=user.getId()%>">삭제</a></td>
				</tr>
			<%} %>
			
		</table>
	<%} %>
</body>
</html>







<%@page import="kr.co.start.members.BankMembersDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberList</title>
</head>
<body>
	<h1>Member List</h1>
	
	<%ArrayList<BankMembersDto> ar = (ArrayList<BankMembersDto>)request.getAttribute("list"); %>
	
	<table border="1">
		<thead>
			<tr>
				<th>UserName</th>
				<th>Name</th>
				<th>Email</th>
				<th>Phone</th>
			</tr>
		</thead>
		<tbody>
			<%for(BankMembersDto bankMembersDto : ar){ %>
			<tr>
				<td><%=bankMembersDto.getUserName() %></td>
				<td><%=bankMembersDto.getName() %></td>
				<td><%=bankMembersDto.getEmail() %></td>
				<td><%=bankMembersDto.getPhone() %></td>
			</tr>
			<%} %>
		</tbody>
	</table>
	
	<a href="/">메인페이지</a>
</body>
</html>
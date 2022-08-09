<%@page import="kr.co.start.bankbook.BankBookDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book</title>
</head>
<body>
	<h1>BankBook Detail</h1>
	
	<%BankBookDto bankBookDto = (BankBookDto)request.getAttribute("detail"); 
	String sale = bankBookDto.getBookSale() == 1 ? "판매중" : "판매금지"; %>
	<h3><%=bankBookDto %></h3>
	
	<table border="1">
		<tr>
			<th>Num</th>
			<th>Name</th>
			<th>Rate</th>
			<th>Sale</th>
		</tr>
		<tr>
			<td><%=bankBookDto.getBookNum() %></td>
			<td><%=bankBookDto.getBookName() %></td>
			<td><%=bankBookDto.getBookRate() %></td>
			<td><%=sale %></td>
		</tr>
	</table>
	
	<!-- /bankbook/detail -->
	<!-- 상대경로 -->
	<!-- url 상 root 즉 /까지 올라가야 하므로 -->
	<a href="../member/login">Login</a>
	<!-- 절대경로 -->
	<a href="/member/join">Join</a>
	
	<a href="/t/tt/ttt/qwer">dummypage</a>
	
	<a href="/">메인페이지</a>
</body>
</html>
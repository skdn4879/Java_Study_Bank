<%@page import="kr.co.start.bankbook.BankBookDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book</title>
</head>
<body>
	<h1>BankBook List</h1>
	<!-- /bankbook/list -->
	<%ArrayList<BankBookDto> ar = (ArrayList<BankBookDto>)request.getAttribute("list"); %>
	<%for(BankBookDto bankBookDto : ar){ %>
		<h3><%=bankBookDto %></h3>
	<%} %>
	
	<table border = "1">
		<thead>
			<tr>
				<th>Name</th><th>Rate</th>
			</tr>
		</thead>
		<tbody>
			<!-- <tr>
				<td>Name1</td>
				<td>0.012</td>
			</tr>
			<tr>
				<td>Name2</td>
				<td>3.14</td>
			</tr> -->
			<%for(BankBookDto bankBookDto : ar){ %>
			<tr>
				<!-- URL 파라미터는 띄어쓰면 안됨 -->
				<td><a href="./detail?bookNum=<%=bankBookDto.getBookNum() %>"> <%=bankBookDto.getBookName() %> </a></td>
				<td><%=bankBookDto.getBookRate() %></td>
			</tr>
			<%} %>
		</tbody>
	</table>
	
	<a href="./detail">detail</a>
	<a href="./add">BankBookAdd</a>
	<a href="/">메인페이지</a>
</body>
</html>
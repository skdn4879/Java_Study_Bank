<%@page import="kr.co.start.bankbook.BankBookDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book</title>
</head>
<body>
	<h1>BankBook List</h1>
	<!-- /bankbook/list -->
	
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
			
			<c:forEach items="${requestScope.list }" var="bankbook">
				<tr>
					<td><a href="./detail?bookNum=${pageScope.bankbook.bookNum }">${pageScope.bankbook.bookName }</a></td>
					<td>${pageScope.bankbook.bookRate }</td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>
	
	<a href="./detail">detail</a>
	<a href="./add">BankBookAdd</a>
	<a href="/">메인페이지</a>
</body>
</html>
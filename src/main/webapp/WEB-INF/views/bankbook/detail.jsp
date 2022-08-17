<%@page import="kr.co.start.bankbook.BankBookDto"%>
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
	<h1>BankBook Detail</h1>
	
	<table border="1">
		<tr>
			<th>Num</th>
			<th>Name</th>
			<th>Rate</th>
			<th>Sale</th>
		</tr>
		<tr>
			<td>${requestScope.detail.bookNum }</td>
			<td>${requestScope.detail.bookName }</td>
			<td>${requestScope.detail.bookRate }</td>
			<td>
				<c:if test="${requestScope.detail.bookSale == 1}">
					판매중
				</c:if>
				<c:if test="${requestScope.detail.bookSale != 1}">
					판매금지
				</c:if>
			
			</td>
		</tr>
	</table>
	
	<!-- /bankbook/detail -->
	<!-- 상대경로 -->
	<!-- url 상 root 즉 /까지 올라가야 하므로 -->
	<a href="../member/login">Login</a>
	<!-- 절대경로 -->
	<a href="/member/join">Join</a>
	
	<a href="/t/tt/ttt/qwer">dummypage</a>
	<a href="./list">리스트보기</a>
	<a href="/">메인페이지</a>
</body>
</html>
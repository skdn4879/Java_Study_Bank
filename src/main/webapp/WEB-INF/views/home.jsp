<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
	
	<c:if test="${ empty sessionScope.member }">
		<a href="/member/login">Login</a>
	</c:if>
	<c:if test="${not empty sessionScope.member }">
		<h4>${sessionScope.member.name }님 환영합니다.</h4>
		<a href="/bankbook/list">BankBookList</a>
		<a href="/bankbook/detail">BankBookDetail</a>
		<a href="/bankbook/add">BankBookAdd</a>
		<a href="/member/search">Search</a>
		<a href="/member/logout">Logout</a>
	</c:if>
	<a href="/member/join">Join</a>
	
</body>
</html>

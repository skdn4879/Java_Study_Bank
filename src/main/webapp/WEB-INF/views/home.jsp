<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
	
	<a href="/member/login">Login</a>
	<a href="/member/join">Join</a>
	<a href="/bankbook/list">BankBookList</a>
	<a href="/bankbook/detail">BankBookDetail</a>
	<a href="/bankbook/add">BankBookAdd</a>
	
</body>
</html>

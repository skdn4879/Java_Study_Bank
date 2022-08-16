<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
	<style>
        *{
            text-align: center;
            margin: 0 auto
        }
        form input{
            text-align: left;
        }
        #id{
            margin: 10px;
        }
        #pw{
            margin: 10px 10px 10px 3px;
        }
        #login{
            margin: 10px;
        }
        #retry{
            margin: 10px;
        }
    </style>
</head>
<body>
	<h1>로그인</h1>
    <form method="post" action="./login">
        ID <input id="id" type="text" name="userName" placeholder="ID입력"><br>
        PW <input id="pw" type="password" name="password" placeholder="PW입력"><br>
        <input id="login" type="submit" value="로그인">
        <input id="retry" type="reset" value="다시입력">
    </form>
    <a href="/">Index Page</a>
</body>
</html>
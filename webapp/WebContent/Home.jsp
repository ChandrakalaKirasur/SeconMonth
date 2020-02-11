<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
body{backgrou-ndcolor:yellow;}
h1{color:pink;}
</style>
<meta charset="UTF-8">
<title>HomePage</title>
</head>
<body>
<h1>Welcome</h1>
<form action="LoginRegister" method="post">
<h3>${message}</h3>
<h3>${successMessage}</h3>
<h3>Login</h3>
UserId<input type="text" name="userID"><br>
Password<input type="password" name="passWord"><br>
<input type="submit" name="submit" value="Login"><br>
<a href="Register.jsp">Register</a>
<br>
<br>
<img alt="Turtile" src="https://upload.wikimedia.org/wikipedia/commons/f/f4/Florida_Box_Turtle_Digon3_re-edited.jpg" height="400" width="400">

</form>
</body>
</html>
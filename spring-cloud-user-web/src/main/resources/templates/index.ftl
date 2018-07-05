<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <form action="/v1/user/login" method="post">
        用户名<input name="name" value=""><br>
        密码<input type="password" name="pass" value=""><br>
        <input type="submit" value="登录"><br/>
    </form>
    <a href="/v1/user/money/15">用户余额</a>
</body>
</html>
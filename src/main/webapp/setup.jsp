<%--
  Created by IntelliJ IDEA.
  User: 傅華暘
  Date: 2017/4/3
  Time: 下午 02:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>setup</title>
    <link rel="stylesheet" type="text/css" href="css/setup.css">
    <script>
        var error = "${error}";
        if(error != null && error.length != 0){
            alert(error);
        }
    </script>
</head>
<body>
<div class="login-page">
    <div class="form">
        <form class="setup-form" action="setupUser" method="post">
            <input name="name" type="text" placeholder="username"/>
            <input name="account" type="text" placeholder="account"/>
            <input name="password" type="password" placeholder="password"/>
            <button type="submit">submit</button>
        </form>
    </div>
</div>
</body>
</html>

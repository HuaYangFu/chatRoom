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
    <script>
        var error = "${error}";
        if(error != null && error.length != 0){
            alert(error);
        }
    </script>
</head>
<body>
    <form action="setupUser" method="post">
        <input name="name" type="text" placeholder="name"/><br/>
        <input name="account" type="text" placeholder="account"/><br/>
        <input name="password" type="password" placeholder="password"/><br/>
        <input type="submit" value="submit"/>
    </form>
</body>
</html>

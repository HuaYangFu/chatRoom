<%--
  Created by IntelliJ IDEA.
  User: 傅華暘
  Date: 2017/3/12
  Time: 下午 03:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/loging.css">
    <script type="text/javascript" src="js/loging.js"></script>
    <script>
        var error = "${error}";
        if(error != null && error.length != 0){
            alert(error);
        }
    </script>
</head>
<body>
<div class="container">
    <div class="profile">
        <button class="profile__avatar" id="toggleProfile">
            <img src="https://pbs.twimg.com/profile_images/554631714970955776/uzPxPPtr.jpeg" alt="Avatar" />
        </button>
        <div class="profile__form">
            <div class="profile__fields">
                <form id="myForm" action="vertify" method="post">
                    <div class="field">
                        <input name="account" type="text" placeholder="Account" id="fieldUser" class="input"/>
                    </div>
                    <div class="field">
                        <input name="password" type="password" placeholder="Password" id="fieldPassword" class="input"/>
                    </div>
                </form>
                <div class="profile__footer">
                    <button class="btn" onclick="formSubmit()">Login</button>
                    <a href="/setupPage"><button class="btn" >Setup</button></a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>


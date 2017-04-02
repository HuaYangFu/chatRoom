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
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script type="text/javascript" src="js/loging.js"></script>
</head>
<body>
<div class="container">
    <div class="profile">
        <button class="profile__avatar" id="toggleProfile">
            <img src="https://pbs.twimg.com/profile_images/554631714970955776/uzPxPPtr.jpeg" alt="Avatar" />
        </button>
        <form id="myForm" action="vertify" method="post">
            <div class="profile__form">
                <div class="profile__fields">
                    <div class="field">
                        <input type="text" id="fieldUser" class="input"/>
                        <label for="fieldUser" class="label">Username</label>
                    </div>
                    <div class="field">
                        <input type="password" id="fieldPassword" class="input"/>
                        <label for="fieldPassword" class="label">Password</label>
                    </div>
                    <div class="profile__footer">
                        <button class="btn" onclick="formSubmit()">Login</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>


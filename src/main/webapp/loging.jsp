<%--
  Created by IntelliJ IDEA.
  User: 傅華暘
  Date: 2017/3/12
  Time: 下午 03:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Elastic Login Form</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>
<!--Google Font - Work Sans-->
<link href='https://fonts.googleapis.com/css?family=Work+Sans:400,300,700' rel='stylesheet' type='text/css'>

<div class="container">
    <div class="profile">
        <button class="profile__avatar" id="toggleProfile">
            <img src="https://pbs.twimg.com/profile_images/554631714970955776/uzPxPPtr.jpeg" alt="Avatar" />
        </button>
        <div class="profile__form">
            <div class="profile__fields">
                <div class="field">
                    <input type="text" id="fieldUser" class="input" required pattern=.*\S.* />
                    <label for="fieldUser" class="label">Username</label>
                </div>
                <div class="field">
                    <input type="password" id="fieldPassword" class="input" required pattern=.*\S.* />
                    <label for="fieldPassword" class="label">Password</label>
                </div>
                <div class="profile__footer">
                    <button class="btn">Login</button>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="js/loging.js"></script>

</body>
</html>


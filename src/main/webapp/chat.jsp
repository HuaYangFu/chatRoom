<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 傅華暘
  Date: 2017/3/12
  Time: 下午 03:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Pretech blog testing web sockets</title>
        <script type="text/javascript" src="js/chat.js"></script>
        <link rel="stylesheet" type="text/css" href="css/chat.css">
        <script>
            function selectUser(id) {
                document.getElementById("to").value = id;
            }
        </script>
    </head>
    <body>
        <h1>chat room</h1>
        <hr>
        <div id="left" style="overflow-y: scroll">
            <c:forEach items="${userList}" var="user">
            <button class="userInfo" onclick="selectUser(${user.id});">
                <c:out value="${user.name}"/>
            </button>
            </c:forEach>
        </div>
        <div id="messages"></div>
        <hr>
        <div>
            <input type="button" id="send" value="Send" onclick="start()"/>
            <input type="text" id="userinput" onkeydown="keyStart()"/>
            <input type="hidden" id="to" value=""/>
        </div>
    </body>
</html>


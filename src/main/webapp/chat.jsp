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
      <style type="text/css">
        #userinput{
          height: 30px;
          width: 96%;
        }
        #send{
          height: 30px;
        }
      </style>
    </head>
    <body>
    <h1>chat room</h1>
    <hr>
    <div style="float: left;width: 30%;height:70%;background-color: greenyellow;">
      sss
    </div>
    <div id="messages" style="width:100%;height:70%;background-color: red;">
    </div>
    <hr>
    <div>
      <input type="button" id="send" value="Send" onclick="start()"/>
      <input type="text" id="userinput" onkeydown="keyStart()"/>
      <input type="hidden" id="to" value=""/>
    </div>
    </body>
</html>


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
  </head>
  <body>
  <div>
    <input type="text" id="userinput" /> <br>
    <input type="submit" value="Send Message to Server" onclick="start()" />
  </div>
  <div id="messages"></div>
    <script type="text/javascript">
      var webSocket = new WebSocket('ws://localhost:8080/websocket');

      webSocket.onerror = function(event) {
        onError(event)
      };

      webSocket.onopen = function(event) {
        onOpen(event)
      };

      webSocket.onmessage = function(event) {
        onMessage(event)
      };

      function onMessage(event) {
        document.getElementById('messages').innerHTML += '<br />'
                + event.data;
      }

      function onOpen(event) {
        document.getElementById('messages').innerHTML = 'Now Connection established';
      }

      function onError(event) {
        alert(event.data);
      }

      function start() {
        var text = document.getElementById("userinput").value;

        webSocket.send(text);
        return false;
      }
    </script>
  </body>
</html>

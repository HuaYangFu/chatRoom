/**
 * Created by 傅華暘 on 2017/3/13.
 */
var webSocket = new WebSocket('ws://localhost:8080/websocket');

webSocket.onerror = function(event) {
    onError(event)
};

webSocket.onopen = function(event) {
    onOpen(event)
};

webSocket.close = function(event) {
    close(event)
};

webSocket.onmessage = function(event) {
    onMessage(event)
};

function onMessage(event) {
    var message = JSON.parse(event.data);
    document.getElementById('messages').innerHTML += '<br />'
        + message.from +" : "+ message.content;
}

function onOpen(event) {
    document.getElementById('messages').innerHTML = 'Now Connection established';
}

function close(event) {
    document.getElementById('messages').innerHTML = 'user is logout';
}

function onError(event) {
    alert(event.data);
}

function start() {
    var content = document.getElementById("userinput").value;
    document.getElementById("userinput").value = null;
    var to = document.getElementById("to").value;
    var self = document.getElementById("self").value;
    var json = JSON.stringify({
        "to":to,
        "from":self.toString(),
        "content":content
    });
    webSocket.send(json);
    return false;
}
function keyStart(e) {
    var code = e.keyCode ? e.keyCode : e.which;
    if(code === 13) {
        start();
    }
}





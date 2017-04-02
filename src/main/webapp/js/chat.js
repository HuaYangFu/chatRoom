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

webSocket.onmessage = function(event) {
    onMessage(event)
};

function onMessage(event) {
    var message = JSON.parse(event.data);
    document.getElementById('messages').innerHTML += '<br />'
        + message.content;
}

function onOpen(event) {
    document.getElementById('messages').innerHTML = 'Now Connection established';
}

function onError(event) {
    alert(event.data);
}

function start() {
    var content = document.getElementById("userinput").value;
    var to = document.getElementById("to").value;
    var json = JSON.stringify({
        "to":to,
        "content":content
    });
    webSocket.send(json);
    return false;
}
function keyStart() {
    var e = window.event;
    if(e.keyCode == 13){
        var content = document.getElementById("userinput").value;
        var to = document.getElementById("to").value;
        var json = JSON.stringify({
            "to":to,
            "content":content
        });
        webSocket.send(json);
        return false;
    }
}


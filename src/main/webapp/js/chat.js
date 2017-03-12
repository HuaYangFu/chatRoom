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
function keyStart() {
    var e = window.event;
    if(e.keyCode == 13){
        var text = document.getElementById("userinput").value;
        webSocket.send(text);
        return false;
    }
}


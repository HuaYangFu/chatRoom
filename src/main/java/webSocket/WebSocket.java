package webSocket;

import chatRoom.entity.Message;
import chatRoom.entity.User;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import javax.xml.ws.WebServiceContext;

/**
 * Created by 傅華暘 on 2017/3/12.
 */
@ServerEndpoint(
        value = "/websocket",
        decoders = MessageDecoder.class,
        encoders = MessageEncoder.class
)
public class WebSocket {

    private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());

    @OnMessage
    public void onMessage(Message message, Session session) throws IOException, EncodeException {
        if(message.getTo() != null && message.getTo().length() != 0){
            sendToOne(message);
        }
        else{
            sendToALL(message);
        }
    }

    @OnOpen
    public void onOpen (Session session) {
        // Add session to the connected sessions set
        clients.add(session);
    }

    @OnClose
    public void onClose (Session session) {
        // Remove session from the connected sessions set
        clients.remove(session);
    }

    private void sendToALL(Message message) throws IOException, EncodeException {
        System.out.print("send to all");
        synchronized(clients){
            for(Session client : clients){
                client.getBasicRemote().sendObject(message);
            }
        }
    }

    private void sendToOne(Message message) throws IOException, EncodeException {
        System.out.print("send to one");
        synchronized(clients){
            for(Session client : clients){
                client.getBasicRemote().sendObject(message);
            }
        }
    }


}

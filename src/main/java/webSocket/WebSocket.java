package webSocket;

import chatRoom.entity.Message;
import chatRoom.entity.User;
import chatRoom.util.UserUtil;

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

    private static Map<Session,User> clients = new HashMap<>();

    private UserUtil userUtil = UserUtil.getInstance();

    @OnMessage
    public void onMessage(Message message, Session session) throws IOException, EncodeException {
        if(message.getTo() != null && message.getTo().length() != 0){
            sendToOne(message,session);
        }
        else{
            sendToALL(message);
        }
    }

    @OnOpen
    public void onOpen (Session session) throws IOException, EncodeException {
        User user = userUtil.getUser();
        clients.put(session,user);
        Message message = new Message();
        message.setFrom(user.getName());
        message.setContent("login");
        sendToALL(message);
    }

    @OnClose
    public void onClose (Session session) throws IOException, EncodeException {
        User user = clients.get(session);
        clients.remove(session);
        Message message = new Message();
        message.setFrom(user.getName());
        message.setContent("disconnected!");
        sendToALL(message);
    }

    private void sendToALL(Message message) throws IOException, EncodeException {
        synchronized(clients){
            Set<Session> sessions = clients.keySet();
            for(Session session : sessions){
                session.getBasicRemote().sendObject(message);
            }
        }
    }

    private void sendToOne(Message message,Session selfsession) throws IOException, EncodeException {
        synchronized(clients){
            Set<Session> users = clients.keySet();
            for(Session session : users){
                User temp = clients.get(session);
                if(temp.getId() == Long.valueOf(message.getTo())){
                    session.getBasicRemote().sendObject(message);
                    selfsession.getBasicRemote().sendObject(message);
                }
            }
        }
    }


}

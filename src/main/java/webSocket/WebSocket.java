package webSocket;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import javax.xml.ws.WebServiceContext;

/**
 * Created by 傅華暘 on 2017/3/12.
 */
@ServerEndpoint("/websocket")
public class WebSocket {

    private static Set<Session> clients =
            Collections.synchronizedSet(new HashSet<Session>());

    @OnMessage
    public void onMessage(String message, Session session)
            throws IOException {

        session.getBasicRemote().sendText(message);
        synchronized(clients){
            for(Session client : clients){
                if (!client.equals(session)){
                    client.getBasicRemote().sendText(message);
                }
            }
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
}

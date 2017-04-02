package webSocket;

import chatRoom.entity.Message;
import com.google.gson.Gson;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 * Created by 傅華暘 on 2017/4/3.
 */
public class MessageDecoder implements Decoder.Text<Message> {

    @Override
    public Message decode(String s) throws DecodeException {

        Gson gson = new Gson();
        Message message = gson.fromJson(s, Message.class);
        return message;
    }

    @Override
    public boolean willDecode(String s) {
        return (s != null);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
        // do nothing
    }

    @Override
    public void destroy() {
        // do nothing
    }
}

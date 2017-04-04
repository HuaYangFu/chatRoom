package chatRoom.util;

import chatRoom.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 傅華暘 on 2017/4/4.
 */
public class UserUtil {

    @Autowired
    private HttpSession session;

    private static Map<HttpSession,User> userMap = new HashMap();

    public Map<HttpSession, User> getUserMap() {
        return userMap;
    }

    public User getUser() {
        User user = userMap.get(session);
        return user;
    }

}

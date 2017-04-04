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

    private UserUtil(){}

    private static UserUtil uniqueInstance;

    @Autowired
    private HttpSession session;

    private static Map<HttpSession,User> userMap = new HashMap();

    public static synchronized UserUtil getInstance() {
        if(uniqueInstance == null ) {uniqueInstance = new UserUtil();}
        return uniqueInstance;
    }

    public Map<HttpSession, User> getUserMap() {
        return userMap;
    }

    public User getUser() {
        User user = userMap.get(session);
        return user;
    }
    public void setUser(User user) {
        userMap.put(session,user);
    }

}

package chatRoom.control;

import chatRoom.dao.UserDao;
import chatRoom.entity.User;
import chatRoom.util.UserUtil;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Created by 傅華暘 on 2017/3/12.
 */
@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/vertify")
    public ModelAndView logingVertify(@RequestParam String account,@RequestParam char[] password) {
        boolean accountIsNotEmpty = (account != null && account.length() != 0);
        boolean passwordIsNotEmpty = (password != null && password.length != 0);
        ModelAndView MV = new ModelAndView("loging");
        if(accountIsNotEmpty && passwordIsNotEmpty) {
            User user = userDao.findUserByProvide(account,password);
            if(user != null){
                UserUtil.getInstance().setUser(user);
                User self = UserUtil.getInstance().getUser();
                MV.addObject("self", self);
                List<User> userList = userDao.findAllUser();
                MV.addObject("userList", userList);
                MV.setViewName("chat");
            }
        }
        MV.addObject("error","user is not exit");
        return MV;
    }

    @RequestMapping("/setupPage")
    public String sendToSetUpPage() {
        return "setup";
    }

    @RequestMapping("/setupUser")
    public ModelAndView creatNewUser(@ModelAttribute User user) throws IOException {
        ModelAndView MV = new ModelAndView("loging");
        try {
            if(user != null){
                userDao.insert(user);
            }
        }catch (Exception e){
            e.printStackTrace();
            MV.addObject("error","account is Duplicate please retry again");
            MV.setViewName("setup");
        }
        return MV;
    }
}

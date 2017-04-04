package chatRoom.control;

import chatRoom.dao.UserDao;
import chatRoom.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
                MV.setViewName("chat");
                List<User> userList = userDao.findAllUser();
                MV.addObject("userList", userList);
            }
        }
        return MV;
    }

    @RequestMapping("/setupPage")
    public String sendToSetUpPage() {
        return "setup";
    }

    @RequestMapping("/setupUser")
    public String creatNewUser(@ModelAttribute User user) {
        try {
            if(user != null){
                userDao.insert(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "loging";
    }
}

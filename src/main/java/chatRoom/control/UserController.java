package chatRoom.control;

import chatRoom.dao.UserDao;
import chatRoom.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ModelAndView test() {
        ModelAndView MV = new ModelAndView("chat");
        List<User> userList = userDao.findAllUser();
        MV.addObject("userList",userList);
        return MV;
    }

    @RequestMapping("/setupPage")
    public String test2() {
        System.out.println("from setupPage use test2");
        return "setup";
    }

    @RequestMapping("/setupUser")
    public String test3(@ModelAttribute User user) {
        System.out.println("from setupUser use test3");
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

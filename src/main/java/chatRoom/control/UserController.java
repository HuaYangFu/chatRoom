package chatRoom.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by 傅華暘 on 2017/3/12.
 */
@Controller
public class UserController {

    @RequestMapping("/vertify")
    public String test() {
        return "chat";
    }
}

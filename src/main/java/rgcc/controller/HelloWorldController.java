package rgcc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import rgcc.entity.User;
import rgcc.service.IUserService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/")
public class HelloWorldController {
    @Resource
    private IUserService userService;

    @RequestMapping(value = "hello")
    @ResponseBody   //会自动封装成json
    public List<User> hello(){
        User user ;
        user = userService.getUserById(3);
        List<User> l=userService.getUsers();
        System.out.println(user.getFirstname());
        return l;
    }

    @RequestMapping("hello2")
    public String hello2(Model model){

        return "helloworld";
    }

}

package rgcc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
    @RequestMapping("/hello")  //��URL��Ϊ/hello��β�Ľ��з���
    public String hello(Model model){
       model.addAttribute("greeting","hello spring mvc"); //����ҳ�е�Ԫ�ظ�ֵ
        return "helloworld"; //�����ض�����ҳ��/helloworld.jsp
    }
}

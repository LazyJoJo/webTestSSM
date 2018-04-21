package rgcc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
  * @author       LazyJoJo
  * @date         2018/4/18 17:50
  * @description  request param ��ʹ��ʵ��
  */
@Controller
public class RequestParamExampleController {
     /*
      * @author       LazyJoJo
      * @date         2018/4/18 17:51
      * @description requestParam �� URL�е��������� e: /user?name=controller
      */
    @RequestMapping("/user")
    public String userInfo(Model model,
                           @RequestParam(value = "name", defaultValue = "Guest") String name){
//        name = EncodingTool.encodeStr(name);//�����������
        model.addAttribute("name",name);
        if("controller".equals(name)){
            model.addAttribute("email",name+"@ruijie.com.cn");
        }else{
            model.addAttribute("email","no set");
        }
        return "userInfo";
    }
}

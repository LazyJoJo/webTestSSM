package rgcc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
  * @author       LazyJoJo
  * @date         2018/4/18 17:39
  * @description
  */
 @Controller
public class RedirectExampleController {
      /*
       * @author       LazyJoJo
       * @date         2018/4/18 17:40
       * @description
       */
      @RequestMapping(value = "/redirect", method = RequestMethod.GET) //�ض��������д��
      public String authorInfo(Model model){

          //do something
          return "redirect:/hello";//��һ��ǰ׺
      }
}

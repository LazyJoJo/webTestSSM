package rgcc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
  * @author       LazyJoJo
  * @date         2018/4/18 17:34
  * @description
  */
@Controller
public class requestResponseController {
     /*
      * @author       LazyJoJo
      * @date         2018/4/18 17:35
      * @description
      */
     @RequestMapping("/request")
     public String requestResponseExample(HttpServletRequest request, HttpServletResponse response, Model model){

        //do something
         return "someView";
     }
}

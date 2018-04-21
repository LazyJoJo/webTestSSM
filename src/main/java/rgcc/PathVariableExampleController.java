package rgcc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/*
  * @author       LazyJoJo
  * @date         2018/4/18 19:14
  * @description
  */
@Controller
public class PathVariableExampleController {
     /*
      * @author       LazyJoJo
      * @date         2018/4/18 19:15
      * @description
      */
     @RequestMapping("/{sitePrefix}/{language}/{id}/{naturalText}")  //�趨URLģ��
     public String documentView(Model model,
                                @PathVariable(value = "sitePrefix") String sitePrefix,
                                @PathVariable(value = "language") String language,
                                @PathVariable(value = "id") Long id,
                                @PathVariable(value ="naturalText") String naturalText){
         model.addAttribute("sitePrefix", sitePrefix);
         model.addAttribute("language", language);
         model.addAttribute("id", id);
         model.addAttribute("naturalText", naturalText);

         String documentName = "Java tutorial for Beginners";
         if(id == 8108) {
             documentName = "Spring MVC for Beginners";
         }
         model.addAttribute("documentName", documentName);

         return "documentView";
     }
}

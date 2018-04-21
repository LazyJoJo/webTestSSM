package rgcc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import rgcc.entity.Student;

/*
  * @author       LazyJoJo
  * @date         2018/4/20 9:25
  * @description  control lever
  */
@Controller
public class StudentController {
     /*
      * @author       LazyJoJo
      * @date         2018/4/20 10:02
      * @description  �����Ѿ���ModelAndView�����д�����һ����Ϊ��command���Ŀն���
      *               ��Ϊ�����JSP��ʹ��<form��form>��ǩ��spring�����Ҫһ����Ϊ��command���Ķ����ļ�
      *               ���Ե�����student()����ʱ��������student.jsp��ͼ
      */
    @RequestMapping(value = "/student" ,method = RequestMethod.GET)
    public ModelAndView student() {
        return new ModelAndView("student","command",new Student());
    }


    @RequestMapping(value = "/addStudent",method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("SpringWeb")Student student, ModelMap modelMap){
        modelMap.addAttribute("name",student.getName());
        modelMap.addAttribute("age",student.getAge());
        modelMap.addAttribute("id",student.getId());

        return "result";
    }
}

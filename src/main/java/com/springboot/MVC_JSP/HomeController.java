package com.springboot.MVC_JSP;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        System.out.println("Home Controller is working");
        return "index";
    }

    //This is done using basic Servlet way
//    @RequestMapping("add")
//    public String add(HttpServletRequest req, HttpSession session) {
//        // HttpServletRequest is used to recieve parameters from the link path formed above
//        // HttpSession this is used to capture any variable in controller and use it in view.
//        int num1 = Integer.parseInt(req.getParameter("num1"));
//        int num2 = Integer.parseInt(req.getParameter("num2"));
//        int result = num1 + num2;
//        session.setAttribute("result", result);
//        return "result.jsp";
//    }

    // This is the Springboot way
//    @RequestMapping("add")
//    public String add(@RequestParam("num1") int num1, @RequestParam("num2") int num2, Model model) {
////    @RequestParam is used like httpsServletRequest and is used to catch the parameter and give them
////    the custom name of the variable
//        int result = num1 + num2;
//        // Model is used like HttpSession and helps in transfering value to View. We can pass this as
//        // method parameter and also as a Method so that value of the method is on the Model.
//        model.addAttribute("result", result);
//
//        return "result"; //.jsp is removed and /views/result is not there as suffix and prefix is configured
//        // in application.properties
//    }

    //Using Model and View for springboot way
            @RequestMapping("add")
        public ModelAndView add(@RequestParam("num1") int num1, @RequestParam("num2") int num2, ModelAndView mv) {

            int result = num1 + num2;
            mv.addObject("result", result); //Here we set the model page
            mv.setViewName("result"); //Here we set the view page (We are not using result.jsp
                // as we have added suffix and prefix)

        return mv;
    }


    // New Mapping to add alien
//    @RequestMapping("addAlien")
//            //We can either use this but this is lengthy as we can have many attributes in a class;
//    public ModelAndView addAlien(@RequestParam("aid") int aid, @RequestParam("aname") String aname, ModelAndView mv) {
//
//        Alien alien=new Alien();
//        alien.setAid(aid);
//        alien.setAname(aname);
//        mv.addObject("alien",alien);
//        mv.setViewName("result");
//
//        return mv;
//    }
    //We can either use this but this is lengthy as we can have many attributes in a class;

    @RequestMapping("alien")
    public String Alien() {
        //We dont need to write @ModelAttribute as just passing the Object also does the work.
        return "alien";
    }

    // Here we use ModelAttribute to get full object from the parameter
    @RequestMapping("alien/addAlien")
        public String addAlien(@ModelAttribute("alien") Alien alien) {
//    public String addAlien(Alien alien) {
        //We dont need to write @ModelAttribute as just passing the Object also does the work.
        return "resultalien";
    }


    // This is used to add course Java as Global variable for view
    @ModelAttribute("course")
    public String courseName() {
        return "Java";
    }
}

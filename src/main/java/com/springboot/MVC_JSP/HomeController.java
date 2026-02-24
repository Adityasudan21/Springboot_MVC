package com.springboot.MVC_JSP;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        System.out.println("Home is working");
        return "index.jsp";
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
    @RequestMapping("add")
    public String add(@RequestParam("num1") int num1, @RequestParam("num2") int num2, Model model) {
//    @RequestParam is used like httpsServletRequest and is used to catch the parameter and give them
//    the custom name of the variable
        int result = num1 + num2;
        // Model is used like HttpSession and helps in transfering value to View. We can pass this as
        // method parameter and also as a Method so that value of the method is on the Model.
        model.addAttribute("result", result);

        return "result.jsp";
    }
}

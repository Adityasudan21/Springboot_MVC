package com.springboot.MVC_JSP;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        System.out.println("Home is working");
        return "index.jsp";
    }

    //This is done using basic Servlet way
    @RequestMapping("add")
    public String add(HttpServletRequest req, HttpSession session) {
        // HttpServletRequest is used to recieve parameters from the link path formed above
        // HttpSession this is used to capture any variable in controller and use it in view.
        int num1=Integer.parseInt(req.getParameter("num1"));
        int num2=Integer.parseInt(req.getParameter("num2"));
        int result=num1+num2;
        session.setAttribute("result", result);

        return "result.jsp";
    }
}

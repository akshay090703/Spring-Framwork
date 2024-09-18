package com.akshay.SpringMVCDemo;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @ModelAttribute("course")
    public String courseName() {
        return "Java";
    }

    @RequestMapping("/")
    public String home() {
    	System.out.println("Home method called");
//        return "index.jsp";
        return "index";
    }

// as the variable name is the same as in the html, that's why it works
// if different variable name, then error
//    public String add(int num1, int num2, HttpSession session) {
//    public String add(@RequestParam("num1") int n1, @RequestParam("num2") int n2, HttpSession session) {
    @RequestMapping("add")
    public ModelAndView add(@RequestParam("num1") int n1, @RequestParam("num2") int n2, ModelAndView mv) {
//        int num1 = Integer.parseInt(req.getParameter("num1"));
//        int num2 = Integer.parseInt(req.getParameter("num2"));
        int result = n1 + n2;

//        model.addAttribute("result", result);
        mv.addObject("result", result);
        mv.setViewName("result");

//        session.setAttribute("result", result);
//        System.out.println(result);

        return mv;
//        return "result.jsp";
    }

    @RequestMapping("addAlien")
//    public ModelAndView addAlien(@RequestParam("aid") int aid, @RequestParam("aname") String aname, ModelAndView mv) {
//    public String addAlien(@ModelAttribute("alien1") Alien alien) {
    public String addAlien(Alien alien) {
//        Alien alien = new Alien();
//        alien.setAid(aid);
//        alien.setAname(aname);

//        mv.addObject("alien", alien);
//        mv.setViewName("result");

        return "result";
    }
}


package com.akshay.jobApp.controllers;

import com.akshay.jobApp.model.jobPost;
import com.akshay.jobApp.services.jobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class JobController {
    @Autowired
    private jobService service;

    @GetMapping({"/home", "/"})
    public String home(){
        return "home";
    }

    @GetMapping("/addjob")
    public String addJob() {
        return "addjob";
    }

    @PostMapping("/handleForm")
    public String handleForm(jobPost jobPost) {
        service.addJob(jobPost);
        return "success";
    }

    @GetMapping("viewalljobs")
    public String viewAllJobs(Model m) {
        List<jobPost> jobs = service.getAllJobs();
        m.addAttribute("jobPosts", jobs);

        return "viewalljobs";
    }
}

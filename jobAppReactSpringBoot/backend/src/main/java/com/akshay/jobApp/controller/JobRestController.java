package com.akshay.jobApp.controller;

import com.akshay.jobApp.model.JobPost;
import com.akshay.jobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {
    @Autowired
    private JobService service;

//    @ResponseBody
    // meaning this will only return the json and not the xml
    // if still asked for xml, will get 406(Not Acceptable)
    @GetMapping(path="/jobPosts", produces = {"application/json"})
    public List<JobPost> getAllJobs() {
        return service.getAllJobs();
    }

    @GetMapping("/jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId) {
        return service.getJob(postId);
    }

    // meaning it can only consume the xml and not json, error Unsupported media type if json used
    @PostMapping(path = "/jobPost", consumes = {"application/json"})
    public JobPost addJob(@RequestBody JobPost jobPost) {
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @PutMapping("/jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("/jobPost/{postId}")
    public void deleteJob(@PathVariable("postId") int postId) {
        service.deleteJob(postId);
//        return service.getAllJobs().size();
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword) {
        return service.search(keyword);
    }

    @GetMapping("load")
    public String loadData() {
        service.load();

        return "Success";
    }
}

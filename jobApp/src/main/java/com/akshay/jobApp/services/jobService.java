package com.akshay.jobApp.services;

import com.akshay.jobApp.model.jobPost;
import com.akshay.jobApp.repository.jobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class jobService {
    @Autowired
    private jobRepo repo;

    public void addJob(jobPost post) {
        repo.addJob(post);
    }

    public List<jobPost> getAllJobs() {
        return repo.getAllJobs();
    }
}

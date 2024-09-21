package com.akshay.jobApp.service;

import com.akshay.jobApp.model.JobPost;
import com.akshay.jobApp.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepo jobRepo;

    public void addJob(JobPost post) {
//        jobRepo.addJob(post);
        jobRepo.save(post);
    }

    public List<JobPost> getAllJobs() {
//        return jobRepo.getAllJobs();
        return jobRepo.findAll();
    }

    public JobPost getJob(int i) {
//        return jobRepo.getJob(i);
        return jobRepo.findById(i).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost) {
//        jobRepo.updateJob(jobPost);
        jobRepo.save(jobPost);
    }

    public void deleteJob(int postId) {
//        jobRepo.deleteJob(postId);
        jobRepo.deleteById(postId);
    }

    public void load() {
        List<JobPost> jobs = new ArrayList<>(
            Arrays.asList(
                    new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                            List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
                    new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
                            3, List.of("HTML", "CSS", "JavaScript", "React")),
                    new JobPost(3, "Network Engineer", "Design and implement computer networks for efficient data communication", 5,
                            List.of("Networking", "Cisco", "Routing", "Switching")),
                    new JobPost(4, "Mobile App Developer", "Experience in mobile app development for iOS and Android",
                            3, List.of("iOS Development", "Android Development", "Mobile App"))
            )
        );

        jobRepo.saveAll(jobs);
    }

    public List<JobPost> search(String keyword) {
        return jobRepo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}

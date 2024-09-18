package com.akshay.jobApp.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.akshay.jobApp.model.jobPost;
import org.springframework.stereotype.Repository;

@Repository
public class jobRepo {
    private List<jobPost> jobs = new ArrayList<>(
            Arrays.asList(
                    new jobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                            List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
                    new jobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
                            3, List.of("HTML", "CSS", "JavaScript", "React")),
                    new jobPost(4, "Network Engineer",
                            "Design and implement computer networks for efficient data communication", 5,
                            List.of("Networking", "Cisco", "Routing", "Switching")),
                    new jobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android",
                            3, List.of("iOS Development", "Android Development", "Mobile App"))
            )
    );

    public List<jobPost> getAllJobs() {
        return jobs;
    }

    public void addJob(jobPost job) {
        jobs.add(job);
    }
}

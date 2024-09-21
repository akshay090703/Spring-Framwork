package com.akshay.jobApp.repository;

import com.akshay.jobApp.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//@Repository
//public class JobRepo {
//    private List<JobPost> jobs = new ArrayList<>(
//            Arrays.asList(
//                    new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
//                            List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
//                    new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
//                            3, List.of("HTML", "CSS", "JavaScript", "React")),
//                    new JobPost(3, "Network Engineer", "Design and implement computer networks for efficient data communication", 5,
//                            List.of("Networking", "Cisco", "Routing", "Switching")),
//                    new JobPost(4, "Mobile App Developer", "Experience in mobile app development for iOS and Android",
//                            3, List.of("iOS Development", "Android Development", "Mobile App"))
//            )
//    );
//
//    public List<JobPost> getAllJobs() {
//        return jobs;
//    }
//
//    public void addJob(JobPost job) {
//        jobs.add(job);
//    }
//
//    public JobPost getJob(int i) {
//        for(JobPost job : jobs) {
//            if(job.getPostId() == i) {
//                return job;
//            }
//        }
//
//        return null;
//    }
//
//    public void updateJob(JobPost jobPost) {
//        for(JobPost post : jobs) {
//            if(post.getPostId() == jobPost.getPostId()) {
//                post.replace(jobPost);
//                break;
//            }
//        }
//    }
//
//    public void deleteJob(int postId) {
////        for(JobPost post : jobs) {
////            if(post.getPostId() == postId) {
////                jobs.remove(post);
////                break;
////            }
////        }
//        Iterator<JobPost> iterator = jobs.iterator();
//        while(iterator.hasNext()) {
//            JobPost job = iterator.next();
//            if(job.getPostId() == postId) {
//                iterator.remove();
//                return;
//            }
//        }
//    }
//}

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {
//    @Query("")
    List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);
}
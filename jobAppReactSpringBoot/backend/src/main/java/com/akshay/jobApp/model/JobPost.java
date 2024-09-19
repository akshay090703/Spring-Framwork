package com.akshay.jobApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class JobPost {
    private int postId;
    private String postProfile;
    private String postDesc;
    private int reqExperience;
    private List<String> postTechStack;

    public void replace(JobPost temp) {
        this.setPostId(temp.getPostId());
        this.setPostProfile(temp.getPostProfile());
        this.setPostDesc(temp.getPostDesc());
        this.setReqExperience(temp.getReqExperience());
        this.setPostTechStack(temp.getPostTechStack());
    }
}

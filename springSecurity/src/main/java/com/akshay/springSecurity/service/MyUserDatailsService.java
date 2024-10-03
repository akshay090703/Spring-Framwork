package com.akshay.springSecurity.service;

import com.akshay.springSecurity.dao.UserRepo;
import com.akshay.springSecurity.model.User;
import com.akshay.springSecurity.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDatailsService implements UserDetailsService {
    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username);

        if(user == null) {
            System.out.println("404 not found");
            throw new UsernameNotFoundException("404 not found");
        }

        return new UserPrincipal(user);
    }
}

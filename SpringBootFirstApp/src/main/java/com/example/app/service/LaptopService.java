package com.example.app.service;

import com.example.app.repo.LaptopRepository;
import com.example.app.model.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Service CLass
// Application is almost same as Component annotation
@Service
public class LaptopService {
    @Autowired
    private LaptopRepository repo;

    public void addLaptop(Laptop lap) {
        repo.save(lap);
    }

    public boolean isGoodForProg(Laptop lap) {
        return true;
    }
}

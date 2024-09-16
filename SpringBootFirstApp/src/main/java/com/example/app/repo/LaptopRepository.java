package com.example.app.repo;

import com.example.app.model.Laptop;
import org.springframework.stereotype.Repository;

// Similar to Component annotation but repository indicates what layer is this
@Repository
public class LaptopRepository {
    public void save(Laptop lap) {
        System.out.println("Saved in Database!");
    }
}

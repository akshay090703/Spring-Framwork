package com.example.app.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Alien {
    @Value("22")
    private int age;

    private Computer com;

    public void code() {
        com.compile();
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Autowired
    @Qualifier("desktop")
    public void setCom(Computer com) {
        this.com = com;
    }

    public int getAge() {
        return this.age;
    }
    public Computer getCom() {
        return this.com;
    }
}

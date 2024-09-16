package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.beans.ConstructorProperties;

@Component
@Scope("prototype")
public class Alien {
    @Value("22")
    private int age;

//    @Autowired
//    @Qualifier("desktop")
//    @Qualifier("com1")
    private Computer com;

    public Alien() {
        System.out.println("ALien object created");
    }

//    @ConstructorProperties({"age", "com"})
//    public Alien(int age, Computer com) {
//        System.out.println("Para constructor called");
//        this.age = age;
//        this.com = com;
//    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Computer getCom() {
        return this.com;
    }

    @Autowired
    // if both qualifier and primary is there then qualifier is preferred
    @Qualifier("com1")
    public void setCom(Computer com) {
        this.com = com;
    }

    public void code() {
        System.out.println("Coding");
        com.compile();
    }
}

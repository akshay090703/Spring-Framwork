package org.example.config;

import org.example.Alien;
import org.example.Computer;
import org.example.Desktop;
import org.example.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("org.example")
public class AppConfig {


//
////    @Bean(name = {"com1", "desktop1", "beast"})
//    @Bean
//    // By default singleton
////    @Scope("prototype")
//    public Desktop desktop() {
//        return new Desktop();
//    }
//
//    @Bean
//    @Primary
//    public Laptop laptop() {
//        return new Laptop();
//    }
//
//    @Bean
//    public Alien alien(@Autowired Computer com) { // @Qualifier("desktop")
//        Alien obj = new Alien();
//        obj.setAge(22);
//        obj.setCom(com);
//        return obj;
//    }
}

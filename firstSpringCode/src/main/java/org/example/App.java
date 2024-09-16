package org.example;
import org.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        Desktop dt = context.getBean("desktop", Desktop.class);
//        dt.compile();
//
//        Desktop dt1 = context.getBean("desktop", Desktop.class);
//        dt1.compile();

        Alien obj1 = context.getBean("alien", Alien.class);
        System.out.println(obj1.getAge());
        obj1.code();





        // XML Based Config
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        Alien obj1 = (Alien) context.getBean("alien");
//        Alien obj1 = context.getBean("alien", Alien.class);
//        Alien obj1 = context.getBean(Alien.class);
//        System.out.println(obj1.getAge());
//        obj1.code();

//        Alien obj2 = (Alien) context.getBean("alien");
//        System.out.println(obj2.age);

        // searches by type
//        Computer com = context.getBean(Computer.class);
    }
}
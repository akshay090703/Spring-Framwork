package com.akshay.SpringDataJPAexample;

import com.akshay.SpringDataJPAexample.model.Student;
import com.akshay.SpringDataJPAexample.repository.StudentRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringDataJpAexampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpAexampleApplication.class, args);

		StudentRepo repo = context.getBean(StudentRepo.class);

		Student s1 = context.getBean("student", Student.class);
		Student s2 = context.getBean("student", Student.class);
		Student s3 = context.getBean("student", Student.class);

		s1.setRollNo(101);
		s1.setName("Akshay");
		s1.setMarks(92);

		s2.setRollNo(102);
		s2.setName("Ayush");
		s2.setMarks(75);

		s3.setRollNo(103);
		s3.setName("Kanishk");
		s3.setMarks(85);

//		repo.save(s2);
//		repo.save(s3);

//		System.out.println(repo.findAll());
		// find based on primary key
//		System.out.println(repo.findById(102));

//		Optional<Student> s = repo.findById(104);
//		System.out.println(s.orElse(new Student()));

//		List<Student> s = repo.findByName("Kanishk");
//		System.out.println(s);

//		System.out.println(repo.findByMarks(92));
//		System.out.println(repo.findByMarksGreaterThan(78));

		// can also be used to update
//		repo.save(s3);
//		System.out.println(repo.findById(103));

		repo.delete(s2);
		System.out.println(repo.findAll());
	}

}

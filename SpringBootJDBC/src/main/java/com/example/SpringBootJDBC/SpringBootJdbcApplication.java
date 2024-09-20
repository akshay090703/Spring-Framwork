package com.example.SpringBootJDBC;

import com.example.SpringBootJDBC.model.Student;
import com.example.SpringBootJDBC.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringBootJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootJdbcApplication.class, args);

		Student s = context.getBean("student", Student.class);
		s.setRollNo(104);
		s.setName("Akshay");
		s.setMarks(93);

		StudentService service = context.getBean("studentService", StudentService.class);

//		service.addStudent(s);

		List<Student> students = service.getStudents();
		System.out.println(students);
	}

}

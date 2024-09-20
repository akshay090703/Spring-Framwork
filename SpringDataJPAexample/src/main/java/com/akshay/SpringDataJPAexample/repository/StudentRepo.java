package com.akshay.SpringDataJPAexample.repository;

import com.akshay.SpringDataJPAexample.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// class we are working with, The data type object of the primary key
public interface StudentRepo extends JpaRepository<Student, Integer> {
    // JPQL - JP Query Lang
    @Query("select s from Student s where s.name = ?1")
    List<Student> findByName(String name);

    List<Student> findByMarks(int marks);

    List<Student> findByMarksGreaterThan(int marks);
}

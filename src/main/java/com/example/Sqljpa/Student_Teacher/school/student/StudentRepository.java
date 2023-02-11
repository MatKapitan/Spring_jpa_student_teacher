package com.example.Sqljpa.Student_Teacher.school.student;


import com.example.Sqljpa.Student_Teacher.school.subject.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {


    Student findByName(String name);

    List<Student> findByNameStartsWith(String name);

    long countByNameLike(String name);

    boolean existsByNameLike(String name);

    @Query (value = "SELECT s FROM student s " +
            "WHERE s.name = :name")
    List<Student> studentByNameJpql(String name);



}


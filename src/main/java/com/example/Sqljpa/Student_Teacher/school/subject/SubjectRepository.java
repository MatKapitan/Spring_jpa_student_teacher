package com.example.Sqljpa.Student_Teacher.school.subject;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

//    // Native query
    @Query(value = "select * from subject where name = :name", nativeQuery = true)
    List<Subject> findByNameNative(String name);

//    // JPQL query
    @Query(value = "SELECT s FROM subject s " +
            " join fetch s.enrolledStudents st " +
            " join fetch s.teacher t " +
            " where t.name = :name"
    )
    List<Subject> findByNameJPQL(String name);
//
//    // JPA query
     List<Subject> findByName(String name);

     List<Subject> findByEnrolledStudents_IdLessThan(Long id);
















}

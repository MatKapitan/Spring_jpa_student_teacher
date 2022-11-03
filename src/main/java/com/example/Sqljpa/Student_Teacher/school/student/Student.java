package com.example.Sqljpa.Student_Teacher.school.student;


import com.example.Sqljpa.Student_Teacher.school.subject.Subject;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    long id;

    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudents")
    private Set<Subject> subjects = new HashSet<>();

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Set<Subject> getSubjects() {
        return subjects;
    }
}

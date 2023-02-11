package com.example.Sqljpa.Student_Teacher.school.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;



    StudentDto studentDtoTransformer(Student student){
        StudentDto dto = new StudentDto();
        dto.setId(student.getId());
        dto.setName(student.getName());
        return dto;
    }

    List<StudentDto> studentDtoTransformerList(List<Student> studentList){
        List<StudentDto> dto = new ArrayList<StudentDto>();
        for (Student student : studentList) {
            dto.add(studentDtoTransformer(student));
        }
        return dto;


    }





    StudentDto getStudentByIdService(Long id) {
         Student x = studentRepository.findById(id).get();
         return studentDtoTransformer(x);
    }

    List<StudentDto> findByNameStartsWithService(String name){
        List<Student> studentList = studentRepository.findByNameStartsWith(name);
        return studentDtoTransformerList(studentList);
    }

    long countByNameLikeService(String name){
        return studentRepository.countByNameLike(name);
    }

    boolean doesNameExistService (String name){
        return studentRepository.existsByNameLike(name);
    }

    List<Student> studentByNameJpqlService(String name){
        return studentRepository.studentByNameJpql(name);
    }



}

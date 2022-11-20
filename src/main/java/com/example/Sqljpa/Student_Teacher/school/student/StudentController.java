package com.example.Sqljpa.Student_Teacher.school.student;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentService studentService;



    @GetMapping
    List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @PostMapping
    Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    //----------------------

    @GetMapping("/findById/{id}")
    StudentDto getStudentById(@PathVariable Long id){
        return studentService.getStudentByIdService(id);
    }

    @GetMapping("/strartsWith")
    List<StudentDto> findByNameStartsWithController(@RequestParam(defaultValue = "Mat", name = "ime") String name){
        return studentService.findByNameStartsWithService(name);
    }
    @GetMapping("/countOfSameName/{name}")
    long countOfStudentsWithSameName(@PathVariable String name){
        return studentService.countByNameLikeService(name);
    }

    @GetMapping("/doesNameExist/{name}")
    boolean doesNameExistControler (@PathVariable String name){
        return studentService.doesNameExistService(name);
    }
}

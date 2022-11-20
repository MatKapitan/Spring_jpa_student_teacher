package com.example.Sqljpa.Student_Teacher.school.teacher;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {


    TeacherDto teacherDtoTransformer(Teacher teacher){
        TeacherDto dto = new TeacherDto();
        dto.setId(teacher.getId());
        dto.setName(teacher.getName());
        return dto;
    }

    List<TeacherDto> teacherDtoTransformerList(List<Teacher> teacherList){
        ArrayList<TeacherDto> dto = new ArrayList<>();
        for (Teacher teacher: teacherList){
            dto.add(teacherDtoTransformer(teacher));
        }
        return dto;
    }
}

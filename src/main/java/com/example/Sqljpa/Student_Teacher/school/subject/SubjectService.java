package com.example.Sqljpa.Student_Teacher.school.subject;

import com.example.Sqljpa.Student_Teacher.school.student.Student;
import com.example.Sqljpa.Student_Teacher.school.student.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class SubjectService {

        @Autowired
        private SubjectRepository subjectRepository;

        @Transactional
        public List<Subject> findAll() {
            return this.subjectRepository.findAll();
        }




        SubjectDto subjectDtoTransformer(Subject subject) {
                SubjectDto dto = new SubjectDto();
                dto.setId(subject.getId());
                dto.setName(subject.getName());
                return dto;
        }

        List<SubjectDto> subjectDtoTransformerList(List<Subject> subjectList){
                List<SubjectDto> dto = new ArrayList<>();
                for( Subject subject : subjectList){
                        dto.add(subjectDtoTransformer(subject));
                }
                return dto;
        }



        SubjectDto getSubjectByIdService(Long id) {
                Subject x = subjectRepository.findById(id).get();
                return subjectDtoTransformer(x);
        }
}

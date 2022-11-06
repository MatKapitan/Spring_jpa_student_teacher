package com.example.Sqljpa.Student_Teacher.school.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class SubjectService {

        @Autowired
        private SubjectRepository subjectRepository;

        @Transactional
        public List<Subject> findAll() {
            return this.subjectRepository.findAll();
        }
}

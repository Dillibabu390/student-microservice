package com.demo.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentService {

    //TODO handle exceptions !!

    public final StudentRepository studentRepository;
    public List<Student> findStudents() {
        return  studentRepository.findAll();
    }

    public Student saveStudents(Student student) {
        return studentRepository.save(student);
    }

  /*  public Student getStudentById(Integer id) {
        return studentRepository.findById(id).get();
    }*/

    public void deleteStudentById(Integer id) {
        studentRepository.deleteById(id);
    }


    public List<Student> findAllStudentsBySchoolId(Integer id) {
        return studentRepository.findAllBySchoolId(id);
    }


}

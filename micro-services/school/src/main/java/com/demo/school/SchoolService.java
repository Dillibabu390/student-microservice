package com.demo.school;

import com.demo.school.client.StudentClient;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SchoolService {

    //TODO handle exceptions !!

    public final SchoolRepository schoolRepository;

    public final StudentClient studentClient;

    public List<School> findSchool() {
        return  schoolRepository.findAll();
    }

    public School saveSchool(School school) {
        return schoolRepository.save(school);
    }

 /*   public School getSchoolById(Integer id) {
        return schoolRepository.findById(id).get();
    }*/

    public void deleteSchoolById(Integer id) {
        schoolRepository.deleteById(id);
    }

    public SchoolResponse findSchoolWithStudents(Integer id) {
        var school = schoolRepository.findById(id)
                .orElse(
                        School.builder()
                                .name("NOT_FOUND")
                                .email("NOT_FOUND")
                                .build()
                );

        var students = studentClient.findAllStudents(id);
        return SchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();


    }
}

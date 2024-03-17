package com.demo.school.client;

import com.demo.school.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "student-service", url = "${application.config.students.url}")
public interface StudentClient {

    @GetMapping("/get/{id}")
    List<Student> findAllStudents(@PathVariable Integer id);

}

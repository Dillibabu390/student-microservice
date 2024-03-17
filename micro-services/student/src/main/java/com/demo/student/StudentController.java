package com.demo.student;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAllStudents(){
        return studentService.findStudents();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudents(student);
    }

   /* @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student getStudentById(@PathVariable Integer id){
        return studentService.getStudentById(id);
    }
*/


    @PostMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Object deleteStudentById(@PathVariable Integer id){
        studentService.deleteStudentById(id);
        return "deleted..";
    }

    @GetMapping("/get/{id}")
    public List<Student> findAllStudents(@PathVariable Integer id){
        return studentService.findAllStudentsBySchoolId(id);
    }


}

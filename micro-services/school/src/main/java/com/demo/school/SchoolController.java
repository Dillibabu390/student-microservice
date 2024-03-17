package com.demo.school;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/school")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<School> getAllStudents(){
        return schoolService.findSchool();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public School saveSchool(@RequestBody School school){
        return schoolService.saveSchool(school);
    }

   /* @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public School getSchoolById(@PathVariable Integer id){
        return schoolService.getSchoolById(id);
    }*/

    @PostMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Object deleteSchoolById(@PathVariable Integer id){
        schoolService.deleteSchoolById(id);
        return "deleted..";
    }

    @GetMapping("/get/{id}")
    public SchoolResponse getAllSchool(@PathVariable Integer id){
        return schoolService.findSchoolWithStudents(id);
    }


}

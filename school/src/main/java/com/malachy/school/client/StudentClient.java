package com.malachy.school.client;

import com.malachy.school.model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "student-service", url = "${application.config.students-url}")

public interface StudentClient {

    @GetMapping("getAllStudentWithSchoolId/{schoolId}")

    List<Student> findAllStudentBySchool(@PathVariable("schoolId") Long schoolId);



}

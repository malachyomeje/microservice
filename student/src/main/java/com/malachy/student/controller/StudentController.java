package com.malachy.student.controller;

import com.malachy.student.dto.request.StudentDto;
import com.malachy.student.dto.request.StudentWithSchoolDto;
import com.malachy.student.dto.response.ApiResponse;
import com.malachy.student.studentService.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("students")
public class StudentController {
private final StudentService studentService;


@PostMapping("registerStudent")
    public ApiResponse registerStudent(StudentDto studentDto){
       return studentService.registerStudent(studentDto);

    }

    @GetMapping("getAllStudent")
    public List<StudentDto> getAllStudent(){
    return studentService.findAllStudent();
    }


    @GetMapping("getAllStudent")
    public ApiResponse<List<StudentWithSchoolDto>> getAllStudentWithSchoolId(Long schoolId){
        return studentService.getAllStudentWithSchoolId(schoolId);
    }


}

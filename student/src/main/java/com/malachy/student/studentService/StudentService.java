package com.malachy.student.studentService;

import com.malachy.student.dto.request.StudentDto;
import com.malachy.student.dto.request.StudentWithSchoolDto;
import com.malachy.student.dto.response.ApiResponse;

import java.util.List;

public interface StudentService {
    ApiResponse registerStudent(StudentDto studentDto);

    List<StudentDto> findAllStudent();

   // ApiResponse<List<StudentWithSchoolDto> >findAllStudent(Long studentId);

    List<StudentWithSchoolDto>getAllStudentWithSchoolId(Long studentId);
}

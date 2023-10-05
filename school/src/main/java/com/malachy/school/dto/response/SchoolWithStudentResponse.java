package com.malachy.school.dto.response;

import com.malachy.school.model.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SchoolWithStudentResponse {
    private String name;
    private String email;
    List<Student> students;
}

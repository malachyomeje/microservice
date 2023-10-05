package com.malachy.school.dto.response;

import com.malachy.school.model.Student;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SchoolWithStudentResponse {
    private String name;
    private String email;
    List<Student> students;
}

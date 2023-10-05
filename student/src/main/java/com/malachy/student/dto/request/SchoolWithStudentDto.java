package com.malachy.student.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SchoolWithStudentDto {

    private String firstName;
    private String lastName;
    private String email;
}

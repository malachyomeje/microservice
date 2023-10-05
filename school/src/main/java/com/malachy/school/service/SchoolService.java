package com.malachy.school.service;

import com.malachy.school.dto.response.SchoolWithStudentResponse;
import com.malachy.school.dto.schoolDto.SchoolDto;
import com.malachy.school.dto.response.ApiResponse;

import java.util.List;

public interface SchoolService {
    ApiResponse registerSchool(SchoolDto schoolDto);

    List<SchoolDto> findAllSchool();

   // SchoolWithStudentResponse schoolWithStudent(String schoolEmail);

    SchoolWithStudentResponse schoolWithStudent(Long studentId);
}

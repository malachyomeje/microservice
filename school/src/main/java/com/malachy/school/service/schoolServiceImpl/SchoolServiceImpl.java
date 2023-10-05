package com.malachy.school.service.schoolServiceImpl;

import com.malachy.school.client.StudentClient;
import com.malachy.school.dto.response.SchoolWithStudentResponse;
import com.malachy.school.dto.schoolDto.SchoolDto;
import com.malachy.school.dto.response.ApiResponse;
import com.malachy.school.model.School;
import com.malachy.school.repository.SchoolRepository;
import com.malachy.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {
    private final SchoolRepository schoolRepository;
    private final StudentClient client;

    @Override
    public ApiResponse registerSchool(SchoolDto schoolDto) {
        Optional<School> school = schoolRepository.findByEmail(schoolDto.getEmail());
        if (school.isPresent()) {
            return new ApiResponse<>("Student Already Exist", schoolDto.getEmail());
        }
        School school1 = School.builder()
                .name(schoolDto.getName())
                .email(schoolDto.getEmail())
                .build();
        schoolRepository.save(school1);
        return new ApiResponse<>("Registration Successfully", school1);
    }

    @Override
    public List<SchoolDto> findAllSchool() {
        List<School> school1 = schoolRepository.findAll();
        List<SchoolDto> list = new ArrayList<>();
        for (School school : school1) {

            SchoolDto schoolDto = new SchoolDto();

            schoolDto.setName(school.getName());
            schoolDto.setEmail(school.getEmail());

            list.add(schoolDto);

        }
        return list;
    }

    @Override
    public SchoolWithStudentResponse schoolWithStudent(Long schoolId) {
        School school = schoolRepository.findById(schoolId)
//        if (school.isEmpty()) {
//            return null;
                .orElse(School.builder()
                        .email("NOT FOUND")
                        .name("NOT FOUND")
                        .build());

      var student = client.findAllStudentBySchool(schoolId); // FIND ALL STUDENT FROM MICROSERVICE

        return SchoolWithStudentResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(student)
                .build();
    }
}

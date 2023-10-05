package com.malachy.school.controller;

import com.malachy.school.dto.response.SchoolWithStudentResponse;
import com.malachy.school.dto.schoolDto.SchoolDto;
import com.malachy.school.dto.response.ApiResponse;
import com.malachy.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequiredArgsConstructor
    @RequestMapping("school")

public class SchoolController {

        private final SchoolService schoolService;


        @PostMapping("registerSchool")
        public ApiResponse registerStudent(@RequestBody SchoolDto schoolDto){
            return schoolService.registerSchool(schoolDto);

        }

        @GetMapping("getAllSchool")
        public List<SchoolDto> getAllSchool(){
            return schoolService.findAllSchool();
        }

        @GetMapping("schoolWithStudent")
        public SchoolWithStudentResponse schoolWithStudent(@RequestParam String schoolEmail){

            return schoolService.schoolWithStudent(schoolEmail);
        }

    }



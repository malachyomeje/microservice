package com.malachy.student.studentService.studentServiceImp;

import com.malachy.student.dto.request.StudentDto;
import com.malachy.student.dto.response.ApiResponse;
import com.malachy.student.model.Students;
import com.malachy.student.repository.StudentsRepository;
import com.malachy.student.studentService.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class StudentServiceImpl implements StudentService {
     private final StudentsRepository studentsRepository;

     @Override
    public ApiResponse registerStudent(StudentDto studentDto){
        Optional<Students> student = studentsRepository.findByEmail(studentDto.getEmail());
        if (student.isPresent()){
            return new ApiResponse<>("Student Already Exist",studentDto.getEmail());
        }
        Students students =Students.builder()
                .firstName(studentDto.getFirstName())
                .lastName(studentDto.getLastName())
                .email(studentDto.getEmail())
                .schoolId(studentDto.getSchoolId())
                .build();
        studentsRepository.save(students);
        return new ApiResponse<>("Registration Successfully",students);
    }


    @Override
    public List<StudentDto> findAllStudent(){
        List<Students> studentsList= studentsRepository.findAll();
        List<StudentDto>list = new ArrayList<>();
        for(Students student1: studentsList){

        StudentDto studentDto= new StudentDto();
           studentDto.setFirstName(student1.getFirstName());
           studentDto.setLastName(student1.getLastName());
           studentDto.setEmail(student1.getEmail());
           studentDto.setSchoolId(studentDto.getSchoolId());

           list.add(studentDto);

        }
        return list;
    }
}

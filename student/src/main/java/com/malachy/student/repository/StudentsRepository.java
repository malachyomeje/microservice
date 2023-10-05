package com.malachy.student.repository;

import com.malachy.student.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentsRepository extends JpaRepository<Students, Long>{

    Optional<Students> findByEmail(String email);

    List<Students>findAllBySchoolId(Long schoolId);
}

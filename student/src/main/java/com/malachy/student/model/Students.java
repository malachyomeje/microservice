package com.malachy.student.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Students {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Long  schoolId;




}

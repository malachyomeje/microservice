package com.malachy.student.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Students {
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Long  schoolId;




}

package com.example.patientformcurd.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    private String name;
    private long age;
    private String sex;
    private String sample;
    private String address;
    private String username;
    private String password;
    private String department;
    private String email;

    @Column(length = 90000)
    private String profileImage;

    @Column(length = 90000)
    private String doc;
    private boolean status;

//    @Temporal(TemporalType.TIMESTAMP)
    private String birthDate;

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private Date submissionDate=new Date();;
    private String submissionDate;
//    private LocalDate dateAndtime;
    private String earning;

}

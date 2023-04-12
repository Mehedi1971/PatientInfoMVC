package com.example.patientformcurd.service;

import com.example.patientformcurd.entity.Patient;
import com.example.patientformcurd.repository.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository patientRepository;


    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatientInfo(){
        return patientRepository.findAll();
    }


//    public String submissionDate(){
//        LocalDate localDate=LocalDate.now();
//        DateTimeFormatter localDate1=DateTimeFormatter.ofPattern("yyyy-MM-dd");
//String sub=localDate.format(localDate1);
//return sub;
//    }

    public Patient savePatientInfo(MultipartFile file1, MultipartFile file2,
                                   Patient patient,
                                   String name,
                                   long age,
                                   String sex,
                                   String sample,
                                   String address,
                                   String username,
                                   String password,
                                   String department,
                                   boolean status,
                                   String birthDate,
                                   String submissionDate,
                                   String earning
                                   ) {
        try{
            patient.setProfileImage(Base64.getEncoder().encodeToString(file1.getBytes()));
            patient.setDoc(Base64.getEncoder().encodeToString(file2.getBytes()));
        }catch (IOException e){
            e.printStackTrace();
        }
//        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        patient.setName(name);
        patient.setAge(age);
        patient.setSex(sex);
        patient.setSample(sample);
        patient.setAddress(address);
        patient.setUsername(username);
        patient.setPassword(password);
        patient.setDepartment(department);
        patient.setStatus(status);
        patient.setBirthDate(birthDate);

        LocalDate localDate=LocalDate.now();
        DateTimeFormatter localDate1=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String sub=localDate.format(localDate1);
        patient.setSubmissionDate(sub);

        patient.setEarning(earning);
//        patient.setBirthDate(formatter.parse(birthDate));


        return patientRepository.save(patient);
    }

    public void deletePatient(long id) {
        this.patientRepository.deleteById(id);
    }

    public Patient showFromForUpdate(long id) {
        Optional<Patient> optional=patientRepository.findById(id);
        Patient patient=optional.get();
        return patient;
    }
}

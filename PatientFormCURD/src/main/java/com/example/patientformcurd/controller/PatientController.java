package com.example.patientformcurd.controller;

import com.example.patientformcurd.entity.Patient;
import com.example.patientformcurd.service.PatientService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class PatientController {
private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/")
    public String allPatientInfo(Model model){
        model.addAttribute("listofAllPatinetInfo",patientService.getAllPatientInfo());
        return "home";
    }

    @GetMapping("/savenewpatientform")
    public String newPatientInfo(Model model){
        Patient patient=new Patient();
        model.addAttribute("newPatient",patient);
        return "newSave";
    }

    @PostMapping("/saveNew")
    public String savePatientInfo( MultipartFile file1,MultipartFile file2,
                                   @ModelAttribute Patient patient,
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
                                   String earning){
        patientService.savePatientInfo(file1,file2,patient,name,age,sex,sample,address,username,password,department,status,birthDate,submissionDate,earning);
        return "redirect:/";
    }

    @GetMapping("/PatientUpdate/{id}")
    public String showFromForUpdate(@PathVariable(value = "id") long id, Model model) {
        Patient patient = patientService.showFromForUpdate(id);
        model.addAttribute("patientupdate", patient);

        return "update";

    }


    @GetMapping("deletePatient/{id}")
    public String deletePatient(@PathVariable(value = "id") long id) {
        this.patientService.deletePatient(id);
        return "redirect:/";
    }

}

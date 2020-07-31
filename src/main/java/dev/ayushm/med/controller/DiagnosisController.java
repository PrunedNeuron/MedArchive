package dev.ayushm.med.controller;

import dev.ayushm.med.model.Diagnosis;
import dev.ayushm.med.service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DiagnosisController {

    @Autowired
    private DiagnosisService diagnosisService;

    @GetMapping("/diagnoses")
    public String getAllDiagnoses(Model model) {
        List<Diagnosis> diagnoses = diagnosisService.getAllDiagnoses();
        model.addAttribute("diagnoses", diagnoses);

        return "diagnoses";
    }

}

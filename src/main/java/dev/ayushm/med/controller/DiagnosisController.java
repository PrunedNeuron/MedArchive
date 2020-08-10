package dev.ayushm.med.controller;

import dev.ayushm.med.model.Diagnosis;
import dev.ayushm.med.service.DiagnosisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DiagnosisController {

    private static final Logger log = LoggerFactory.getLogger(DiagnosisController.class);

    private final DiagnosisService diagnosisService;

    @Autowired
    public DiagnosisController(DiagnosisService diagnosisService) {
        this.diagnosisService = diagnosisService;
    }

    @GetMapping("/diagnoses")
    public String getAllDiagnoses(Model model) {
        log.info("Retrieving list of all diagnoses...");
        List<Diagnosis> diagnoses = diagnosisService.getAllDiagnoses();
        model.addAttribute("diagnoses", diagnoses);

        return "pages/error";
    }

}

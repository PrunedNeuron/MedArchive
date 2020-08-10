package dev.ayushm.med.api.controller;

import dev.ayushm.med.model.Diagnosis;
import dev.ayushm.med.service.DiagnosisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DiagnosisRestController {

    private static final Logger log = LoggerFactory.getLogger(DiagnosisRestController.class);
    private final DiagnosisService diagnosisService;

    @Autowired
    public DiagnosisRestController(DiagnosisService diagnosisService) {
        this.diagnosisService = diagnosisService;
    }

    @GetMapping("/diagnoses")
    public List<Diagnosis> getAllDiagnoses() {
        log.info("Received GET request on /api/diagnoses, responding with a list of all diagnoses.");
        return diagnosisService.getAllDiagnoses();
    }

    @PostMapping("/diagnoses")
    public String addDiagnosis(@RequestBody Diagnosis diagnosis) {
        log.info("Received a POST request on /api/diagnoses, adding diagnosis to the database.");
        try {
            diagnosisService.addDiagnosis(diagnosis);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return "Failed to add diagnosis.";
        }
        return "Successfully added diagnosis.";
    }

}

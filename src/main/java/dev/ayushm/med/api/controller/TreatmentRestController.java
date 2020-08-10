package dev.ayushm.med.api.controller;

import dev.ayushm.med.model.Treatment;
import dev.ayushm.med.service.TreatmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TreatmentRestController {

    private static final Logger log = LoggerFactory.getLogger(TreatmentRestController.class);
    private final TreatmentService treatmentService;

    @Autowired
    public TreatmentRestController(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    @GetMapping("/treatments")
    public List<Treatment> getAllTreatments() {
        log.info("Received GET request on /api/treatments, responding with a list of all treatments.");
        return treatmentService.getAllTreatmentsSorted();
    }

    @PostMapping("/treatments")
    public String addTreatment(@RequestBody Treatment treatment) {
        log.info("Received a POST request on /api/treatments, adding treatment to the database.");
        try {
            treatmentService.addTreatment(treatment);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return "Failed to add treatment.";
        }
        return "Successfully added treatment.";
    }

}

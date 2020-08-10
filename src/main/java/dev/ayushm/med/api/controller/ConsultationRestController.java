package dev.ayushm.med.api.controller;

import dev.ayushm.med.model.Consultation;
import dev.ayushm.med.service.ConsultationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ConsultationRestController {

    private static final Logger log = LoggerFactory.getLogger(ConsultationRestController.class);
    private final ConsultationService consultationService;

    @Autowired
    public ConsultationRestController(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @GetMapping("/consultations")
    public List<Consultation> getAllConsultations() {
        log.info("Received GET request on /api/consultations, responding with a list of all consultations.");
        return consultationService.getAllConsultationsSorted();
    }

    @PostMapping("/consultations")
    public String addConsultation(@RequestBody Consultation consultation) {
        log.info("Received a POST request on /api/consultations, adding consultation to the database.");
        try {
            consultationService.addConsultation(consultation);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return "Failed to add consultation.";
        }
        return "Successfully added consultation.";
    }

    @DeleteMapping("/consultations/{consultationId}")
    public String deletePatient(@PathVariable Integer consultationId) {
        log.info("Received a DELETE request on /api/consultations/{consultationId}, deleting consultation");

        try {
            consultationService.deleteConsultation(consultationId);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return "Failed to delete consultation.";
        }

        return "Successfully deleted consultation.";
    }

}

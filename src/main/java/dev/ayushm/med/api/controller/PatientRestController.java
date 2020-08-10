package dev.ayushm.med.api.controller;

import dev.ayushm.med.model.Patient;
import dev.ayushm.med.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientRestController {

    private static final Logger log = LoggerFactory.getLogger(PatientRestController.class);
    private final PatientService patientService;

    @Autowired
    public PatientRestController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        log.info("Received GET request on /api/patients, responding with a list of all patients.");
        return patientService.getAllPatients();
    }

    @PostMapping("/patients")
    public String addPatient(@RequestBody Patient patient) {
        log.info("Received a POST request on /api/patients, adding patient to the database.");

        try {
            patientService.addPatient(patient);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return "Failed to add patient.";
        }

        return "Successfully added patient.";
    }

    @DeleteMapping("/patients/{patientId}")
    public String deletePatient(@PathVariable Integer patientId) {
        log.info("Received a DELETE request on /api/patients/{patientId}, deleting patient");

        try {
            patientService.deletePatient(patientId);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return "Failed to delete patient.";
        }

        return "Successfully deleted patient.";
    }

    @GetMapping("/patients/search")
    public List<String> searchPatients(@RequestParam(value = "term", required = false, defaultValue = "") String term) {
        log.info("Received GET request on /api/patients/search, responding with search result.");
        return patientService.search(term);
    }

}

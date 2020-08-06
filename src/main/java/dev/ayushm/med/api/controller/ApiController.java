package dev.ayushm.med.api.controller;

import dev.ayushm.med.model.*;
import dev.ayushm.med.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private static final Logger log = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    private PatientService patientService;

    @Autowired
    private ConsultantService consultantService;

    @Autowired
    private IllnessService illnessService;

    @Autowired
    private DrugService drugService;

    @Autowired
    private ConsultationService consultationService;

    @Autowired
    private DiagnosisService diagnosisService;

    @Autowired
    private TreatmentService treatmentService;

    @Autowired
    private TestService testService;

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

    @GetMapping("/patients/search")
    public List<String> searchPatients(@RequestParam(value = "term", required = false, defaultValue = "") String term) {
        log.info("Received GET request on /api/patients/search, responding with search result.");
        return patientService.search(term);
    }

    @GetMapping("/consultants")
    public List<Consultant> getAllConsultants() {
        log.info("Received GET request on /api/patients, responding with a list of all consultants.");
        return consultantService.getAllConsultants();
    }

    @PostMapping("/consultants")
    public String addConsultant(@RequestBody Consultant consultant) {
        log.info("Received a POST request on /api/consultants, adding consultant to the database.");
        try {
            consultantService.addConsultant(consultant);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return "Failed to add consultant.";
        }
        return "Successfully added consultant";
    }

    @GetMapping("/consultants/search")
    public List<String> searchConsultants(@RequestParam(value = "term", required = false, defaultValue = "") String term) {
        log.info("Received GET request on /api/consultants/search, responding with search result.");
        return consultantService.search(term);
    }

    @GetMapping("/illnesses")
    public List<Illness> getAllIllnesses() {
        log.info("Received GET request on /api/illnesses, responding with a list of all illnesses.");
        return illnessService.getAllIllnesses();
    }

    @PostMapping("/illnesses")
    public String addIllness(@RequestBody Illness illness) {
        log.info("Received a POST request on /api/illnesses, adding illness to the database.");
        try {
            illnessService.addIllness(illness);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return "Failed to add illness.";
        }
        return "Successfully added illness.";
    }

    @GetMapping("/illnesses/search")
    public List<String> searchIllnesses(@RequestParam(value = "term", required = false, defaultValue = "") String term) {
        log.info("Received GET request on /api/illnesses/search, responding with search result.");
        return illnessService.search(term);
    }

    @GetMapping("/drugs")
    public List<Drug> getAllDrugs() {
        log.info("Received GET request on /api/drugs, responding with a list of all drugs.");
        return drugService.getAllDrugs();
    }

    @PostMapping("/drugs")
    public String addDrug(@RequestBody Drug drug) {

        log.info("Received a POST request on /api/drugs, adding drug to the database.");
        try {
            drugService.addDrug(drug);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return "Failed to add drug.";
        }
        return "Successfully added drug.";
    }

    @GetMapping("/drugs/search")
    public List<String> searchDrugs(@RequestParam(value = "term", required = false, defaultValue = "") String term) {
        log.info("Received GET request on /api/drugs/search, responding with search result.");
        return drugService.search(term);
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

    @GetMapping("/tests")
    public List<Test> getAllTests() {
        log.info("Received GET request on /api/tests, responding with a list of all tests.");
        return testService.getAllTests();
    }

    @PostMapping("/tests")
    public String addTest(@RequestBody Test test) {
        log.info("Received a POST request on /api/tests, adding test to the database.");
        try {
            testService.addTest(test);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return "Failed to add test.";
        }
        return "Successfully added test.";
    }

    @GetMapping("/tests/search")
    public List<String> searchTests(@RequestParam(value = "term", required = false, defaultValue = "") String term) {
        log.info("Received GET request on api/tests/search, responding with search result.");
        return testService.search(term);
    }

}

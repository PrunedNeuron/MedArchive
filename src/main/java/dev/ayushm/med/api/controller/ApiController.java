package dev.ayushm.med.api.controller;

import dev.ayushm.med.model.*;
import dev.ayushm.med.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

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
        return patientService.getAllPatients();
    }

    @PostMapping("/patients")
    public void addPatient(@RequestBody Patient patient) {
        patientService.addPatient(patient);
    }

    @GetMapping("/consultants")
    public List<Consultant> getAllConsultants() {
        return consultantService.getAllConsultants();
    }

    @PostMapping("/consultants")
    public void addConsultant(@RequestBody Consultant consultant) {
        consultantService.addConsultant(consultant);
    }

    @GetMapping("/illnesses")
    public List<Illness> getAllIllnesses() {
        return illnessService.getAllIllnesses();
    }

    @PostMapping("/illnesses")
    public void addIllness(@RequestBody Illness illness) {
        illnessService.addIllness(illness);
    }

    @GetMapping("/drugs")
    public List<Drug> getAllDrugs() {
        return drugService.getAllDrugs();
    }

    @PostMapping("/drugs")
    public void addDrug(@RequestBody Drug drug) {
        drugService.addDrug(drug);
    }

    @GetMapping("/consultations")
    public List<Consultation> getAllConsultations() {
        return consultationService.getAllConsultationsSorted();
    }

    @PostMapping("/consultations")
    public void addConsultation(@RequestBody Consultation consultation) {
        consultationService.addConsultation(consultation);
    }

    @GetMapping("/diagnoses")
    public List<Diagnosis> getAllDiagnoses() {
        return diagnosisService.getAllDiagnoses();
    }

    @PostMapping("/diagnoses")
    public void addDiagnosis(@RequestBody Diagnosis diagnosis) {
        diagnosisService.addDiagnosis(diagnosis);
    }

    @GetMapping("/treatments")
    public List<Treatment> getAllTreatments() {
        return treatmentService.getAllTreatmentsSorted();
    }

    @PostMapping("/treatments")
    public void addTreatment(@RequestBody Treatment treatment) {
        treatmentService.addTreatment(treatment);
    }

    @GetMapping("/tests")
    public List<Test> getAllTests() {
        return testService.getAllTests();
    }

    @PostMapping("/tests")
    public void addTest(@RequestBody Test test) {
        testService.addTest(test);
    }

}

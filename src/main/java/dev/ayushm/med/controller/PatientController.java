package dev.ayushm.med.controller;

import dev.ayushm.med.model.*;
import dev.ayushm.med.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/patients")
public class PatientController {

    private static final Logger log = LoggerFactory.getLogger(PatientController.class);

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("")
    public String getAllPatients(Model model) {

        List<Patient> patients = patientService.getAllPatients();
        model.addAttribute("patients", patients);

        return "pages/patients";
    }

    @GetMapping("/{patientId}")
    public String getPatient(@PathVariable Integer patientId, Model model) {

        log.info("Retrieving patient with the given patient ID...");
        Patient patient = patientService.getPatient(patientId);

        log.info("Retrieving consultations attended by the patient with the given patient ID...");
        List<Consultation> consultationList = patientService.getConsultations(patientId);

        log.info("Retrieving diagnoses of the patient with the given patient ID...");
        List<Diagnosis> diagnosisList = patientService.getDiagnoses(patientId);

        log.info("Retrieving treatments associated with the patient with the given patient ID...");
        List<Treatment> treatmentList = patientService.getTreatments(patientId);

        log.info("Retrieving drugs prescribed to the patient with the given patient ID...");
        List<Drug> drugList = patientService.getDrugs(patientId);
        List<Illness> illnessList = patientService.getIllnesses(patientId);

        log.info("Converting the list of drugs into a comma separated string");
        String drugs = new HashSet<>(drugList)
                .stream()
                .map(drug -> String.valueOf(drug.getDrugName()))
                .collect(Collectors.joining(", "));

        log.info("Converting the list of diagnoses/illnesses into a comma separated string...");
        String illnesses = new HashSet<>(illnessList)
                .stream()
                .map(illness -> String.valueOf(illness.getIllnessName()))
                .collect(Collectors.joining(", "));

        log.info("Converting the list of drugs that the patient is allergic to into an array of strings...");
        String[] allergicDrugs = patientService.getPatient(patientId).getPatientAllergicTo().split(" ");

        for (Drug drug : drugList)
            for (String allergicDrug : allergicDrugs)
                if (drug.getDrugName().equalsIgnoreCase(allergicDrug)) {
                    model.addAttribute("allergyAlert", true);
                    break;
                }


        model.addAttribute("consultations", consultationList);
        model.addAttribute("diagnoses", diagnosisList);
        model.addAttribute("treatments", treatmentList);
        model.addAttribute("drugs", drugs);
        model.addAttribute("illnesses", illnesses);
        model.addAttribute("patient", patient);


        return "pages/patients";
    }

    @GetMapping("{patientId}/history")
    public String getPatientHistory(@PathVariable Integer patientId, Model model) {

        log.info("Retrieving consultations attended by the patient with the given patient ID...");
        List<Consultation> consultations = patientService.getConsultations(patientId);
        model.addAttribute("patient", patientService.getPatient(patientId));
        model.addAttribute("consultations", consultations);

        return "pages/history";
    }

}

package dev.ayushm.med.controller;

import dev.ayushm.med.model.*;
import dev.ayushm.med.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/patients")
public class PatientController {

    private static final Logger log = LoggerFactory.getLogger(PatientController.class);

    @Autowired
    private PatientService patientService;

    @GetMapping("")
    public String getAllPatients(Model model) {

        List<Patient> patients = patientService.getAllPatients();
        model.addAttribute("patients", patients);

        return "pages/patients";
    }

    @GetMapping("/{patientId}")
    public String getPatient(@PathVariable Integer patientId, Model model) {
        Patient patient = patientService.getPatient(patientId);
        List<Consultation> consultationList = patientService.getConsultations(patientId);
        List<Diagnosis> diagnosisList = patientService.getDiagnoses(patientId);
        List<Treatment> treatmentList = patientService.getTreatments(patientId);
        List<Drug> drugList = patientService.getDrugs(patientId);
        List<Illness> illnessList = patientService.getIllnesses(patientId);

        String drugs = new HashSet<Drug>(drugList)
                .stream()
                .map(drug -> String.valueOf(drug.getDrugName()))
                .collect(Collectors.joining(", "));

        String illnesses = new HashSet<Illness>(illnessList)
                .stream()
                .map(illness -> String.valueOf(illness.getIllnessName()))
                .collect(Collectors.joining(", "));

        String[] allergicDrugs = patientService.getPatient(patientId).getPatientAllergicTo().split(" ");

        log.info("Allergic Drugs: " + Arrays.toString(allergicDrugs));
        log.info("On drugs: " + drugs);

        for (Drug drug : drugList)
            for (String allergicDrug : allergicDrugs)
                if (drug.getDrugName().equalsIgnoreCase(allergicDrug))
                    model.addAttribute("allergyAlert", true);

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
        List<Consultation> consultations = patientService.getConsultations(patientId);
        model.addAttribute("patient", patientService.getPatient(patientId));
        model.addAttribute("consultations", consultations);

        return "pages/history";
    }

}

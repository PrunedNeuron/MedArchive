package dev.ayushm.med.controller;

import dev.ayushm.med.database.Populator;
import dev.ayushm.med.model.*;
import dev.ayushm.med.service.ConsultantService;
import dev.ayushm.med.service.ConsultationService;
import dev.ayushm.med.service.PatientService;
import dev.ayushm.med.utility.DateFormatUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController {

    @Autowired
    private ConsultationService consultationService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private ConsultantService consultantService;

    static int counter = 0;

    @GetMapping("/")
    public String index(Model model, @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        model.addAttribute("name", name);
        if (counter++ == 0)
            Populator.populate();

        List<Consultation> consultations = consultationService.getAllConsultations();
        model.addAttribute("consultations", consultations);

        return "index";
    }

    @GetMapping("/patients")
    public String patients(Model model) {

        List<Patient> patients = patientService.getAllPatients();
        model.addAttribute("patients", patients);

        return "patients";
    }

    @GetMapping("/patients/{patientId}")
    public String patient(@PathVariable Integer patientId, Model model) {
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

        System.out.println(drugs);

        String illnesses = new HashSet<Illness>(illnessList)
                .stream()
                .map(illness -> String.valueOf(illness.getIllnessName()))
                .collect(Collectors.joining(", "));

        System.out.println(illnesses);

        model.addAttribute("consultations", consultationList);
        model.addAttribute("diagnoses", diagnosisList);
        model.addAttribute("treatments", treatmentList);
        model.addAttribute("drugs", drugs);
        model.addAttribute("illnesses", illnesses);
        model.addAttribute("patient", patient);


        return "patients";
    }


    @GetMapping("/consultants/{consultantId}")
    public String consultant(@PathVariable Integer consultantId, Model model) {
        Consultant consultant = consultantService.getConsultant(consultantId);
        model.addAttribute("consultant", consultant);

        return "patients";
    }

    @GetMapping("/consultations")
    public String consultations(Model model) {

        List<Consultation> consultations = consultationService.getAllConsultations();
        model.addAttribute("consultationList", consultations);

        return "consultations";
    }

    @GetMapping("/consultations/{consultationId}")
    public String consultation(@PathVariable Integer consultationId, Model model) {
        Consultation consultation = consultationService.getConsultation(consultationId);
        model.addAttribute("consultation", consultation);
        model.addAttribute("consultationDate", DateFormatUtility.formatIntoWords(consultation.getConsultationDate()));

        return "consultations";
    }

}

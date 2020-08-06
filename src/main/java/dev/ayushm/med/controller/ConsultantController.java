package dev.ayushm.med.controller;

import dev.ayushm.med.model.Consultant;
import dev.ayushm.med.model.Patient;
import dev.ayushm.med.service.ConsultantService;
import dev.ayushm.med.service.ConsultationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ConsultantController {

    private static final Logger log = LoggerFactory.getLogger(ConsultantController.class);

    @Autowired
    private ConsultantService consultantService;

    @Autowired
    private ConsultationService consultationService;

    @GetMapping("/consultants")
    public String getAllConsultants(Model model) {
        log.info("Retrieving list of all consultants...");
        List<Consultant> consultants = consultantService.getAllConsultants();
        model.addAttribute("consultants", consultants);

        return "pages/consultants";
    }

    @GetMapping("/consultants/{consultantId}")
    public String getConsultant(@PathVariable Integer consultantId, Model model) {
        log.info("Retrieving consultant with the given ID...");
        Consultant consultant = consultantService.getConsultant(consultantId);
        model.addAttribute("consultant", consultant);

        return "pages/consultants";
    }

    @GetMapping("/consultants/{consultantId}/patients")
    public String getConsultantPatients(@PathVariable Integer consultantId, Model model) {
        log.info("Retrieving patients treated by the consultant with the given ID...");
        Consultant consultant = consultantService.getConsultant(consultantId);
        List<Patient> patients = new ArrayList<>();

        consultationService
                .getAllConsultations()
                .stream()
                .filter(consultation -> consultation.getConsultant().equals(consultant))
                .map(consultation -> consultation.getPatient())
                .distinct()
                .collect(Collectors.toList())
                .forEach(patients::add);

        patients.forEach(patient -> log.info(patient.toString()));

        model.addAttribute("consultant", consultant);
        model.addAttribute("patients", patients);

        return "pages/consultantPatients";
    }

}

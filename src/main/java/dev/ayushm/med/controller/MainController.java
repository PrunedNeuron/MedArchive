package dev.ayushm.med.controller;

import dev.ayushm.med.database.Populator;
import dev.ayushm.med.model.Consultation;
import dev.ayushm.med.model.Patient;
import dev.ayushm.med.service.ConsultationService;
import dev.ayushm.med.service.PatientService;
import dev.ayushm.med.utility.DateFormatUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ConsultationService consultationService;

    @Autowired
    private PatientService patientService;

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

    @PostMapping("/search")
    public String search(@ModelAttribute("query") String query, BindingResult result, Model model) {
        if (result.hasErrors())
            return "index";

        model.addAttribute("query", query);
        return "search";
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
        model.addAttribute("patient", patient);

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

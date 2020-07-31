package dev.ayushm.med.controller;

import dev.ayushm.med.model.Consultation;
import dev.ayushm.med.service.ConsultationService;
import dev.ayushm.med.utility.DateFormatUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    @GetMapping("/consultations")
    public String getAllConsultations(Model model) {

        List<Consultation> consultations = consultationService.getAllConsultations();
        model.addAttribute("consultationList", consultations);

        return "consultations";
    }

    @GetMapping("/consultations/{consultationId}")
    public String getConsultation(@PathVariable Integer consultationId, Model model) {
        Consultation consultation = consultationService.getConsultation(consultationId);
        model.addAttribute("consultation", consultation);
        model.addAttribute("consultationDate", DateFormatUtility.formatIntoWords(consultation.getConsultationDate()));

        return "consultations";
    }
}

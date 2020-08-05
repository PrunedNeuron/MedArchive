package dev.ayushm.med.controller;

import dev.ayushm.med.model.Consultation;
import dev.ayushm.med.model.Diagnosis;
import dev.ayushm.med.model.Treatment;
import dev.ayushm.med.service.ConsultationService;
import dev.ayushm.med.service.DiagnosisService;
import dev.ayushm.med.service.TreatmentService;
import dev.ayushm.med.utility.DateFormatUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    @Autowired
    private DiagnosisService diagnosisService;

    @Autowired
    private TreatmentService treatmentService;

    @GetMapping("/consultations")
    public String getAllConsultations(Model model) {

        List<Consultation> consultations = consultationService.getAllConsultations();
        model.addAttribute("consultationList", consultations);

        return "pages/consultations";
    }

    @GetMapping("/consultations/{consultationId}")
    public String getConsultation(@PathVariable Integer consultationId, Model model) {
        Consultation consultation = consultationService.getConsultation(consultationId);
        List<Diagnosis> diagnoses = diagnosisService.geDiagnosisByConsultationId(consultationId);
        List<Treatment> treatments = treatmentService.getTreatmentsByConsultationId(consultationId);

        String illnesses = new HashSet<Diagnosis>(diagnoses)
                .stream()
                .map(diagnosis -> String.valueOf(diagnosis.getIllness().getIllnessName()))
                .collect(Collectors.joining(", "));

        String drugs = new HashSet<Treatment>(treatments)
                .stream()
                .map(treatment -> String.valueOf(treatment.getDrug().getDrugName()))
                .collect(Collectors.joining(", "));

        model.addAttribute("consultation", consultation);
        model.addAttribute("consultationDate", DateFormatUtility.formatIntoWords(consultation.getConsultationDate()));
        model.addAttribute("diagnoses", illnesses);
        model.addAttribute("drugs", drugs);

        return "pages/consultations";
    }
}

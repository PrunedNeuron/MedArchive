package dev.ayushm.med.controller;

import dev.ayushm.med.model.Consultation;
import dev.ayushm.med.model.Treatment;
import dev.ayushm.med.service.ConsultationService;
import dev.ayushm.med.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private static final Integer counter = 6;

    @Autowired
    ConsultationService consultationService;

    @Autowired
    TreatmentService treatmentService;

    @GetMapping("/")
    public String index(Model model) throws IOException {

        List<Consultation> consultations = new ArrayList<>(new ArrayList<>(consultationService.getAllConsultationsSorted()).subList(0, 5));
        List<Treatment> treatments = new ArrayList<>(new ArrayList<>(treatmentService.getAllTreatmentsSorted()).subList(0, 5));
        model.addAttribute("consultations", consultations);
        model.addAttribute("treatments", treatments);

        return "pages/index";
    }

    @GetMapping("/error")
    public String error() {
        return "pages/error";
    }

}

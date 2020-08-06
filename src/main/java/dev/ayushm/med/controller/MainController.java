package dev.ayushm.med.controller;

import dev.ayushm.med.model.Consultation;
import dev.ayushm.med.model.Treatment;
import dev.ayushm.med.service.ConsultationService;
import dev.ayushm.med.service.TreatmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    @Autowired
    ConsultationService consultationService;

    @Autowired
    TreatmentService treatmentService;

    @GetMapping("/")
    public String index(Model model) throws IOException {

        log.info("Retrieving list of consultations and treatments, both sorted and sliced.");
        List<Consultation> consultations = new ArrayList<>(new ArrayList<>(consultationService.getAllConsultationsSorted()).subList(0, 5));
        List<Treatment> treatments = new ArrayList<>(new ArrayList<>(treatmentService.getAllTreatmentsSorted()).subList(0, 5));
        model.addAttribute("consultations", consultations);
        model.addAttribute("treatments", treatments);

        return "pages/index";
    }

    @GetMapping("/error")
    public String error() {
        log.info("Probably encountered an error, returning error page!");
        return "pages/error";
    }

}

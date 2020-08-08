package dev.ayushm.med.controller;

import dev.ayushm.med.model.Treatment;
import dev.ayushm.med.service.TreatmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class TreatmentController {

    private static final Logger log = LoggerFactory.getLogger(TreatmentController.class);

    private final TreatmentService treatmentService;

    @Autowired
    public TreatmentController(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    @GetMapping("/treatments")
    public String getAllTreatments(Model model) {
        log.info("Retrieving list of treatments...");
        Set<String> seen = new HashSet<>();
        List<Treatment> treatments = new ArrayList<>();
        treatmentService.getAllTreatmentsSorted().forEach(treatment -> {
            String joined = treatment.getDiagnosis().getIllness().getIllnessName() + treatment.getDrug().getDrugName();
            if (!seen.contains(joined))
                treatments.add(treatment);
            seen.add(joined);
        });

        model.addAttribute("treatments", treatments);

        return "pages/treatments";
    }

    @GetMapping("/treatments/{treatmentId}") // Currently unused
    public String getTest(@PathVariable Integer treatmentId, Model model) {
        log.info("Retrieving treatment with the given treatment ID...");
        Treatment treatment = treatmentService.getTreatment(treatmentId);
        model.addAttribute("treatment", treatment);

//        return "pages/treatments";
        return "pages/error";
    }

}

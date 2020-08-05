package dev.ayushm.med.controller;

import dev.ayushm.med.model.Treatment;
import dev.ayushm.med.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TreatmentController {

    @Autowired
    private TreatmentService treatmentService;

    @GetMapping("/treatments")
    public String getAllTreatments(Model model) {
        List<Treatment> treatments = treatmentService.getAllTreatmentsSorted();
        model.addAttribute("treatments", treatments);

        return "pages/treatments";
    }

}

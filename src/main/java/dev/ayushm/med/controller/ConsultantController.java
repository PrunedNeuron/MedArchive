package dev.ayushm.med.controller;

import dev.ayushm.med.model.Consultant;
import dev.ayushm.med.service.ConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ConsultantController {

    @Autowired
    private ConsultantService consultantService;

    @GetMapping("/consultants")
    public String getAllConsultants(Model model) {
        List<Consultant> consultants = consultantService.getAllConsultants();
        model.addAttribute("consultants", consultants);

        return "consultants";
    }

    @GetMapping("/consultants/{consultantId}")
    public String getConsultant(@PathVariable Integer consultantId, Model model) {
        Consultant consultant = consultantService.getConsultant(consultantId);
        model.addAttribute("consultant", consultant);

        return "consultants";
    }

}

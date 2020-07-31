package dev.ayushm.med.controller;

import dev.ayushm.med.model.Drug;
import dev.ayushm.med.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DrugController {

    @Autowired
    private DrugService drugService;

    @GetMapping("/drugs")
    public String getAllDrugs(Model model) {
        List<Drug> drugs = drugService.getAllDrugs();
        model.addAttribute("drugs", drugs);

        return "drugs";
    }

}

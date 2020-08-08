package dev.ayushm.med.controller;

import dev.ayushm.med.model.Drug;
import dev.ayushm.med.service.DrugService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class DrugController {

    private static final Logger log = LoggerFactory.getLogger(DrugController.class);

    private final DrugService drugService;

    @Autowired
    public DrugController(DrugService drugService) {
        this.drugService = drugService;
    }

    @GetMapping("/drugs")
    public String getAllDrugs(Model model) {
        log.info("Retrieving list of all drugs...");
        List<Drug> drugs = drugService.getAllDrugs();
        model.addAttribute("drugs", drugs);

        return "pages/drugs";
    }

    @GetMapping("/drugs/{drugId}")
    public String getDrug(@PathVariable Integer drugId, Model model) {
        log.info("Retrieving drug with the given drug ID...");
        Drug drug = drugService.getDrug(drugId);
        model.addAttribute("drug", drug);

        return "pages/drugs";
    }

}

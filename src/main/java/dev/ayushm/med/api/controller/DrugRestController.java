package dev.ayushm.med.api.controller;

import dev.ayushm.med.model.Drug;
import dev.ayushm.med.service.DrugService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DrugRestController {

    private static final Logger log = LoggerFactory.getLogger(DrugRestController.class);
    private final DrugService drugService;

    @Autowired
    public DrugRestController(DrugService drugService) {
        this.drugService = drugService;
    }

    @GetMapping("/drugs")
    public List<Drug> getAllDrugs() {
        log.info("Received GET request on /api/drugs, responding with a list of all drugs.");
        return drugService.getAllDrugs();
    }

    @PostMapping("/drugs")
    public String addDrug(@RequestBody Drug drug) {

        log.info("Received a POST request on /api/drugs, adding drug to the database.");
        try {
            drugService.addDrug(drug);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return "Failed to add drug.";
        }
        return "Successfully added drug.";
    }

    @GetMapping("/drugs/search")
    public List<String> searchDrugs(@RequestParam(value = "term", required = false, defaultValue = "") String term) {
        log.info("Received GET request on /api/drugs/search, responding with search result.");
        return drugService.search(term);
    }

}

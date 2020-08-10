package dev.ayushm.med.api.controller;

import dev.ayushm.med.model.Illness;
import dev.ayushm.med.service.IllnessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class IllnessRestController {

    private static final Logger log = LoggerFactory.getLogger(IllnessRestController.class);
    private final IllnessService illnessService;

    @Autowired
    public IllnessRestController(IllnessService illnessService) {
        this.illnessService = illnessService;
    }

    @GetMapping("/illnesses")
    public List<Illness> getAllIllnesses() {
        log.info("Received GET request on /api/illnesses, responding with a list of all illnesses.");
        return illnessService.getAllIllnesses();
    }

    @PostMapping("/illnesses")
    public String addIllness(@RequestBody Illness illness) {
        log.info("Received a POST request on /api/illnesses, adding illness to the database.");
        try {
            illnessService.addIllness(illness);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return "Failed to add illness.";
        }
        return "Successfully added illness.";
    }

    @GetMapping("/illnesses/search")
    public List<String> searchIllnesses(@RequestParam(value = "term", required = false, defaultValue = "") String term) {
        log.info("Received GET request on /api/illnesses/search, responding with search result.");
        return illnessService.search(term);
    }

}

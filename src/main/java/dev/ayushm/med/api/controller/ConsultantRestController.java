package dev.ayushm.med.api.controller;

import dev.ayushm.med.model.Consultant;
import dev.ayushm.med.service.ConsultantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ConsultantRestController {

    private static final Logger log = LoggerFactory.getLogger(ConsultantRestController.class);
    private final ConsultantService consultantService;

    @Autowired
    public ConsultantRestController(ConsultantService consultantService) {
        this.consultantService = consultantService;
    }

    @GetMapping("/consultants")
    public List<Consultant> getAllConsultants() {
        log.info("Received GET request on /api/patients, responding with a list of all consultants.");
        return consultantService.getAllConsultants();
    }

    @PostMapping("/consultants")
    public String addConsultant(@RequestBody Consultant consultant) {
        log.info("Received a POST request on /api/consultants, adding consultant to the database.");
        try {
            consultantService.addConsultant(consultant);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return "Failed to add consultant.";
        }
        return "Successfully added consultant";
    }

    @DeleteMapping("/consultants/{consultantId}")
    public String deleteConsultant(@PathVariable Integer consultantId) {
        log.info("Received a DELETE request on /api/consultants/{consultantId}, deleting consultant");

        try {
            consultantService.deleteConsultant(consultantId);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return "Failed to delete consultant.";
        }

        return "Successfully deleted consultant.";
    }


    @GetMapping("/consultants/search")
    public List<String> searchConsultants(@RequestParam(value = "term", required = false, defaultValue = "") String term) {
        log.info("Received GET request on /api/consultants/search, responding with search result.");
        return consultantService.search(term);
    }

}

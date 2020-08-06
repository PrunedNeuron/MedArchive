package dev.ayushm.med.controller;

import dev.ayushm.med.model.Illness;
import dev.ayushm.med.service.IllnessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class IllnessController {

    private static final Logger log = LoggerFactory.getLogger(IllnessController.class);

    @Autowired
    private IllnessService illnessService;

    @GetMapping("/illnesses")
    public String getAllIllnesses(Model model) {
        log.info("Retrieving list of all illnesses...");
        List<Illness> illnesses = illnessService.getAllIllnesses();
        model.addAttribute("illnesses", illnesses);

        return "pages/illnesses";
    }

    @GetMapping("/illnesses/{illnessId}")
    public String getIllness(@PathVariable Integer illnessId, Model model) {
        log.info("Retrieving illness with the given illness ID...");
        Illness illness = illnessService.getIllness(illnessId);
        model.addAttribute("illness", illness);

        return "pages/illnesses";
    }

}

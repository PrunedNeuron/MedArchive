package dev.ayushm.med.controller;

import dev.ayushm.med.model.Illness;
import dev.ayushm.med.service.IllnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IllnessController {

    @Autowired
    private IllnessService illnessService;

    @GetMapping("/illnesses")
    public String getAllIllnesses(Model model) {
        List<Illness> illnesses = illnessService.getAllIllnesses();
        model.addAttribute("illnesses", illnesses);

        return "illnesses";
    }

}

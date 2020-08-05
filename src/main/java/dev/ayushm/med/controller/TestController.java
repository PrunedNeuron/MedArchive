package dev.ayushm.med.controller;

import dev.ayushm.med.model.Test;
import dev.ayushm.med.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/tests")
    public String getAllTests(Model model) {
        List<Test> tests = testService.getAllTests();
        model.addAttribute("tests", tests);

        return "pages/tests";
    }

    @GetMapping("/tests/{testId}")
    public String getTest(@PathVariable Integer testId, Model model) {
        Test test = testService.getTest(testId);
        model.addAttribute("test", test);

        return "pages/tests";
    }

}

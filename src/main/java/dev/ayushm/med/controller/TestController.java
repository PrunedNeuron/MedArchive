package dev.ayushm.med.controller;

import dev.ayushm.med.model.Test;
import dev.ayushm.med.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/tests")
    public String getAllTests(Model model) {
        log.info("Retrieving list of all tests...");
        List<Test> tests = testService.getAllTests().stream().distinct().collect(Collectors.toList());
        model.addAttribute("tests", tests);

        return "pages/tests";
    }

    @GetMapping("/tests/{testId}")
    public String getTest(@PathVariable Integer testId, Model model) {
        log.info("Retrieving test with the given test ID...");
        Test test = testService.getTest(testId);
        model.addAttribute("test", test);

        return "pages/tests";
    }

}

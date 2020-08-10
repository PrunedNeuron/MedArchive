package dev.ayushm.med.api.controller;

import dev.ayushm.med.model.Test;
import dev.ayushm.med.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestRestController {

    private static final Logger log = LoggerFactory.getLogger(TestRestController.class);
    private final TestService testService;

    @Autowired
    public TestRestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/tests")
    public List<Test> getAllTests() {
        log.info("Received GET request on /api/tests, responding with a list of all tests.");
        return testService.getAllTests();
    }

    @PostMapping("/tests")
    public String addTest(@RequestBody Test test) {
        log.info("Received a POST request on /api/tests, adding test to the database.");
        try {
            testService.addTest(test);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return "Failed to add test.";
        }
        return "Successfully added test.";
    }

    @GetMapping("/tests/search")
    public List<String> searchTests(@RequestParam(value = "term", required = false, defaultValue = "") String term) {
        log.info("Received GET request on api/tests/search, responding with search result.");
        return testService.search(term);
    }

}

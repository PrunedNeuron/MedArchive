package dev.ayushm.med.service;

import dev.ayushm.med.model.Test;
import dev.ayushm.med.repository.TestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestService {

    private static final Logger log = LoggerFactory.getLogger(TestService.class);

    private final TestRepository testRepository;

    @Autowired
    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public List<Test> getAllTests() {
        log.info("Retrieving list of all tests in the repository...");
        List<Test> tests = new ArrayList<>();
        testRepository.findAll().forEach(tests::add);
        return tests;
    }

    public Test getTest(Integer testId) {
        return testRepository.findById(testId).orElse(null);
    }

    public Test addTest(Test test) {
        return testRepository.save(test);
    }

    public List<String> search(String keyword) {
        log.info("Searching for tests with a matching name...");
        return testRepository.findByTestNameContaining(keyword).stream().map(Test::getTestName).collect(Collectors.toList());
    }


    public List<Test> getTestsByName(String name) {
        return testRepository.findByTestNameContaining(name);
    }

}

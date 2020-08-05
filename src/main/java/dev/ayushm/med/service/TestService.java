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

    private static final Logger logger = LoggerFactory.getLogger(TestService.class);

    @Autowired
    private TestRepository testRepository;

    public List<Test> getAllTests() {
        List<Test> tests = new ArrayList<>();
        testRepository.findAll().forEach(tests::add);
        return tests;
    }

    public Test getTest(Integer testId) {
        return testRepository.findById(testId).get();
    }

    public Test addTest(Test test) {
        return testRepository.save(test);
    }

    public List<String> search(String keyword) {
        logger.info("SEARCH RESULT = " + testRepository.findByTestNameContaining(keyword));
        return testRepository.findByTestNameContaining(keyword).stream().map(object -> object.getTestName()).collect(Collectors.toList());
    }


    public List<Test> getTestsByName(String name) {
        return testRepository.findByTestNameContaining(name);
    }

}

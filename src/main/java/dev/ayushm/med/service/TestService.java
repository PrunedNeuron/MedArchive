package dev.ayushm.med.service;

import dev.ayushm.med.model.Test;
import dev.ayushm.med.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {

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

    public void addTest(Test test) {
        testRepository.save(test);
    }

}

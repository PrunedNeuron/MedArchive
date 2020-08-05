package dev.ayushm.med.service;

import dev.ayushm.med.model.Illness;
import dev.ayushm.med.repository.IllnessRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IllnessService {

    private static final Logger logger = LoggerFactory.getLogger(IllnessService.class);

    @Autowired
    private IllnessRepository illnessRepository;

    public List<Illness> getAllIllnesses() {
        List<Illness> illnesses = new ArrayList<>();
        illnessRepository.findAll().forEach(illnesses::add);
        return illnesses;
    }

    public Illness getIllness(Integer illnessId) {
        return illnessRepository.findById(illnessId).get();
    }

    public Illness addIllness(Illness illness) {
        return illnessRepository.save(illness);
    }

    public List<String> search(String keyword) {
        logger.info("SEARCH RESULT = " + illnessRepository.findByIllnessNameContaining(keyword));
        return illnessRepository.findByIllnessNameContaining(keyword).stream().map(object -> object.getIllnessName()).collect(Collectors.toList());
    }

    public List<Illness> getIllnessesByName(String name) {
        return illnessRepository.findByIllnessNameContaining(name);
    }

}

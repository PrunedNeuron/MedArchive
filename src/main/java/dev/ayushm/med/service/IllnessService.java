package dev.ayushm.med.service;

import dev.ayushm.med.model.Illness;
import dev.ayushm.med.repository.IllnessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IllnessService {

    @Autowired
    private IllnessRepository illnessRepository;

    public List<Illness> getAllIllnesses() {
        List<Illness> illnesses = new ArrayList<>();
        illnessRepository.findAll().forEach(illnesses::add);
        return illnesses;
    }

    public void addIllness(Illness illness) {
        illnessRepository.save(illness);
    }

}

package dev.ayushm.med.service;

import dev.ayushm.med.model.Consultant;
import dev.ayushm.med.repository.ConsultantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultantService {

    @Autowired
    private ConsultantRepository consultantRepository;

    public List<Consultant> getAllConsultants() {
        List<Consultant> consultants = new ArrayList<>();
        consultantRepository.findAll().forEach(consultants::add);
        return consultants;
    }

    public Consultant getConsultant(Integer consultantId) {
        return  consultantRepository.findById(consultantId).get();
    }

    public void addConsultant(Consultant consultant) {
        consultantRepository.save(consultant);
    }

}

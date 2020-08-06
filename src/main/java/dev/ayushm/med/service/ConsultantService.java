package dev.ayushm.med.service;

import dev.ayushm.med.model.Consultant;
import dev.ayushm.med.repository.ConsultantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultantService {

    private static final Logger log = LoggerFactory.getLogger(ConsultationService.class);

    @Autowired
    private ConsultantRepository consultantRepository;

    public List<Consultant> getAllConsultants() {

        log.info("Retrieving all consultants from the database.");

        List<Consultant> consultants = new ArrayList<>();
        consultantRepository.findAll().forEach(consultants::add);

        log.info("Retrieved all consultants from the database, returning.");

        return consultants;
    }

    public Consultant getConsultant(Integer consultantId) {
        return  consultantRepository.findById(consultantId).get();
    }

    public Consultant addConsultant(Consultant consultant) {

        log.info("Adding consultant to the database.");
        return consultantRepository.save(consultant);

    }

    public List<String> search(String keyword) {
        log.info("Searching...");
        return consultantRepository
                .findByConsultantNameContaining(keyword)
                .stream()
                .map(consultant -> consultant.getConsultantName())
                .collect(Collectors.toList());
    }

    public List<Consultant> getConsultantsByName(String name) {
        log.info("Retrieving consultant with the given name...");
        return consultantRepository.findByConsultantNameContaining(name);
    }

}

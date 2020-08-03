package dev.ayushm.med.service;

import dev.ayushm.med.model.Consultant;
import dev.ayushm.med.repository.ConsultantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultantService {

    private static final Logger logger = LoggerFactory.getLogger(ConsultationService.class);

    @Autowired
    private ConsultantRepository consultantRepository;

    public List<Consultant> getAllConsultants() {

        logger.info("Retrieving all consultants from the database.");

        List<Consultant> consultants = new ArrayList<>();
        consultantRepository.findAll().forEach(consultants::add);

        logger.info("Retrieved all consultants from the database, returning.");

        return consultants;
    }

    public Consultant getConsultant(Integer consultantId) {
        return  consultantRepository.findById(consultantId).get();
    }

    public void addConsultant(Consultant consultant) {

        logger.info("Adding consultant with name = " + consultant.getConsultantName() + " to the database.");
        consultantRepository.save(consultant);
        logger.info("Added consultant with name = " + consultant.getConsultantName() + " to the database.");

    }

}

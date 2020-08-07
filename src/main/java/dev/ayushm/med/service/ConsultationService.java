package dev.ayushm.med.service;

import dev.ayushm.med.model.Consultation;
import dev.ayushm.med.repository.ConsultationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ConsultationService {

    private static final Logger logger = LoggerFactory.getLogger(ConsultationService.class);

    @Autowired
    private ConsultationRepository consultationRepository;

    public List<Consultation> getAllConsultations() {

        logger.info("Retrieving all consultants from the database.");

        List<Consultation> consultations = new ArrayList<>();
        consultationRepository.findAll().forEach(consultations::add);

        logger.info("Retrieved all consultants from the database.");
        return consultations;
    }

    public List<Consultation> getAllConsultationsSorted() {
        logger.info("Retrieving all consultants from the database ordered by date desc.");
        List<Consultation> consultations = new ArrayList<>(consultationRepository.findAllByOrderByConsultationDateDesc());
        logger.info("Retrieved all consultants from the database ordered by date desc.");

        Collections.reverse(consultations);
        return consultations;
    }

    public Consultation getConsultation(Integer consultationId) {
        return  consultationRepository.findById(consultationId).orElse(null);
    }

    public Consultation addConsultation(Consultation consultation) {
        logger.info("Adding consultation with given patient ID and consultant ID to the database.");
        return consultationRepository.save(consultation);
    }

}

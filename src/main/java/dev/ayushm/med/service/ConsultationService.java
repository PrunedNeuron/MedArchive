package dev.ayushm.med.service;

import dev.ayushm.med.model.Consultation;
import dev.ayushm.med.repository.ConsultationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<Consultation> consultations = new ArrayList<>();
        consultationRepository.findAllByOrderByConsultationDateDesc().forEach(consultations::add);
        logger.info("Retrieved all consultants from the database ordered by date desc.");
        return consultations;
    }

    public Consultation getConsultation(Integer consultationId) {
        return  consultationRepository.findById(consultationId).get();
    }

    public void addConsultation(Consultation consultation) {

        logger.info("Adding consultation with patient ID = " + consultation.getPatientId() + " and consultant ID = " + consultation.getConsultantId() + " to the database.");
        consultationRepository.save(consultation);
        logger.info("Added consultation with patient ID = " + consultation.getPatientId() + " and consultant ID = " + consultation.getConsultantId() + " to the database.");
    }

}

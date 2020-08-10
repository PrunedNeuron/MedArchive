package dev.ayushm.med.service;

import dev.ayushm.med.model.Consultation;
import dev.ayushm.med.repository.ConsultationRepository;
import dev.ayushm.med.repository.DiagnosisRepository;
import dev.ayushm.med.repository.TreatmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultationService {

    private static final Logger log = LoggerFactory.getLogger(ConsultationService.class);

    private final ConsultationRepository consultationRepository;
    private final TreatmentRepository treatmentRepository;
    private final DiagnosisRepository diagnosisRepository;

    @Autowired
    public ConsultationService(ConsultationRepository consultationRepository, TreatmentRepository treatmentRepository, DiagnosisRepository diagnosisRepository) {
        this.consultationRepository = consultationRepository;
        this.treatmentRepository = treatmentRepository;
        this.diagnosisRepository = diagnosisRepository;
    }

    public List<Consultation> getAllConsultations() {

        log.info("Retrieving all consultants from the database.");

        List<Consultation> consultations = new ArrayList<>();
        consultationRepository.findAll().forEach(consultations::add);

        log.info("Retrieved all consultants from the database.");
        return consultations;
    }

    public List<Consultation> getAllConsultationsSorted() {
        log.info("Retrieving all consultants from the database ordered by date desc.");
        List<Consultation> consultations = consultationRepository.findAllByOrderByConsultationDateDesc();
        log.info("Retrieved all consultants from the database ordered by date desc.");

        return consultations;
    }

    public Consultation getConsultation(Integer consultationId) {
        return consultationRepository.findById(consultationId).orElse(null);
    }

    public Consultation addConsultation(Consultation consultation) {
        log.info("Adding consultation with given patient ID and consultant ID to the database.");
        return consultationRepository.save(consultation);
    }

    public void deleteConsultation(Integer consultationId) {

        diagnosisRepository.findAll().forEach(diagnosis -> {
            if (diagnosis.getConsultationId().equals(consultationId)) {
                log.info("Deleting consultation's treatments...");
                treatmentRepository.findAll().forEach(treatment -> {
                    if (treatment.getDiagnosisId().equals(diagnosis.getDiagnosisId()))
                        treatmentRepository.delete(treatment);
                });

                log.info("Deleting consultation's diagnoses...");
                diagnosisRepository.delete(diagnosis);
            }
        });

        log.info("Deleting consultation...");
        consultationRepository.deleteById(consultationId);
    }
}

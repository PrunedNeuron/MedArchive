package dev.ayushm.med.service;

import dev.ayushm.med.model.Consultant;
import dev.ayushm.med.repository.ConsultantRepository;
import dev.ayushm.med.repository.ConsultationRepository;
import dev.ayushm.med.repository.DiagnosisRepository;
import dev.ayushm.med.repository.TreatmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultantService {

    private static final Logger log = LoggerFactory.getLogger(ConsultationService.class);

    private final ConsultantRepository consultantRepository;
    private final ConsultationRepository consultationRepository;
    private final DiagnosisRepository diagnosisRepository;
    private final TreatmentRepository treatmentRepository;

    @Autowired
    public ConsultantService(ConsultantRepository consultantRepository, ConsultationRepository consultationRepository, DiagnosisRepository diagnosisRepository, TreatmentRepository treatmentRepository) {
        this.consultantRepository = consultantRepository;
        this.consultationRepository = consultationRepository;
        this.diagnosisRepository = diagnosisRepository;
        this.treatmentRepository = treatmentRepository;
    }

    public List<Consultant> getAllConsultants() {

        log.info("Retrieving all consultants from the database.");

        List<Consultant> consultants = new ArrayList<>();
        consultantRepository.findAll().forEach(consultants::add);

        log.info("Retrieved all consultants from the repository, returning.");

        Collections.reverse(consultants);
        return consultants;
    }

    public Consultant getConsultant(Integer consultantId) {
        log.info("Retrieving consultant with given ID form the repository.");
        return consultantRepository.findById(consultantId).orElse(null);
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
                .map(Consultant::getConsultantName)
                .collect(Collectors.toList());
    }

    public List<Consultant> getConsultantsByName(String name) {
        log.info("Retrieving consultant with the given name...");
        return consultantRepository.findByConsultantNameContaining(name);
    }

    public void deleteConsultant(Integer consultantId) {

        consultationRepository.findAll().forEach(consultation -> {
            if (consultation.getConsultantId().equals(consultantId)) {
                log.info("Deleting consultant's treatments...");
                treatmentRepository.findAll().forEach(treatment -> {
                    if (treatment.getDiagnosis().getConsultation().getConsultationId().equals(consultation.getConsultationId()))
                        treatmentRepository.delete(treatment);
                });

                log.info("Deleting consultant's diagnoses...");
                diagnosisRepository.findAll().forEach(diagnosis -> {
                    if (diagnosis.getConsultationId().equals(consultation.getConsultationId()))
                        diagnosisRepository.delete(diagnosis);
                });

                log.info("Deleting consultant's consultations...");
                consultationRepository.delete(consultation);
            }
        });

        log.info("Deleting consultant...");
        consultantRepository.deleteById(consultantId);
    }

}

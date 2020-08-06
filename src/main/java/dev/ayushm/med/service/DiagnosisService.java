package dev.ayushm.med.service;

import dev.ayushm.med.model.Diagnosis;
import dev.ayushm.med.repository.DiagnosisRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiagnosisService {

    private static final Logger log = LoggerFactory.getLogger(DiagnosisService.class);

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    public List<Diagnosis> getAllDiagnoses() {
        log.info("Retrieving all diagnoses from the repository...");
        List<Diagnosis> diagnoses = new ArrayList<>();
        diagnosisRepository.findAll().forEach(diagnoses::add);
        return diagnoses;
    }

    public Diagnosis getDiagnosis(Integer diagnosisId) {
        log.info("Retrieving diagnosis with the given diagnosis ID from the repository...");
        return diagnosisRepository.findById(diagnosisId).get();
    }

    public Diagnosis addDiagnosis(Diagnosis diagnosis) {
        log.info("Adding diagnosis to repository...");
        return diagnosisRepository.save(diagnosis);
    }

    public List<Diagnosis> geDiagnosisByConsultationId(Integer consultationId) {
        List<Diagnosis> diagnoses = new ArrayList<>();

        log.info("Finding diagnoses with matching consultation ID...");
        diagnosisRepository.findAll().forEach(diagnosis -> {
            if (diagnosis.getConsultationId() == consultationId)
                diagnoses.add(diagnosis);
        });

        return diagnoses;
    }

}

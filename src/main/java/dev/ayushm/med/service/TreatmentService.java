package dev.ayushm.med.service;

import dev.ayushm.med.model.Treatment;
import dev.ayushm.med.repository.TreatmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TreatmentService {

    private static final Logger log = LoggerFactory.getLogger(TreatmentService.class);

    @Autowired
    private TreatmentRepository treatmentRepository;

    public List<Treatment> getAllTreatments() {
        log.info("Retrieving list of all treatments from the repository...");
        List<Treatment> treatments = new ArrayList<>();
        treatmentRepository.findAll().forEach(treatments::add);
        return treatments;
    }

    public List<Treatment> getAllTreatmentsSorted() {
        log.info("Retrieving sorted list of all treatments from the repository...");
        return new ArrayList<>(treatmentRepository.findAllByOrderByDiagnosis_Consultation_ConsultationDateDesc());
    }

    public Treatment getTreatment(Integer treatmentId) {
        return treatmentRepository.findById(treatmentId).orElse(null);
    }

    public Treatment addTreatment(Treatment treatment) {
        return treatmentRepository.save(treatment);
    }

    public List<Treatment> getTreatmentsByConsultationId(Integer consultationId) {
        log.info("Retrieving list of treatments with a matching consultation ID...");
        List<Treatment> treatments = new ArrayList<>();
        treatmentRepository.findAll().forEach(treatment -> {
            if (treatment.getDiagnosis().getConsultationId().equals(consultationId))
                treatments.add(treatment);
        });

        return treatments;
    }

}

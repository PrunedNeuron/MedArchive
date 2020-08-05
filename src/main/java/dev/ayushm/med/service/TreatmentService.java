package dev.ayushm.med.service;

import dev.ayushm.med.model.Treatment;
import dev.ayushm.med.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TreatmentService {

    @Autowired
    private TreatmentRepository treatmentRepository;

    public List<Treatment> getAllTreatments() {
        List<Treatment> treatments = new ArrayList<>();
        treatmentRepository.findAll().forEach(treatments::add);
        return treatments;
    }

    public List<Treatment> getAllTreatmentsSorted() {
        List<Treatment> treatments = new ArrayList<>();
        treatmentRepository.findAllByOrderByDiagnosis_Consultation_ConsultationDateDesc().forEach(treatments::add);
        return treatments;
    }

    public Treatment getTreatment(Integer treatmentId) {
        return treatmentRepository.findById(treatmentId).get();
    }

    public Treatment addTreatment(Treatment treatment) {
        return treatmentRepository.save(treatment);
    }

    public List<Treatment> getTreatmentsByConsultationId(Integer consultationId) {
        List<Treatment> treatments = new ArrayList<>();
        treatmentRepository.findAll().forEach(treatment -> {
            if (treatment.getDiagnosis().getConsultationId() == consultationId)
                treatments.add(treatment);
        });

        return treatments;
    }

}

package dev.ayushm.med.service;

import dev.ayushm.med.model.Consultation;
import dev.ayushm.med.repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    public List<Consultation> getAllConsultations() {
        List<Consultation> consultations = new ArrayList<>();
        consultationRepository.findAll().forEach(consultations::add);
        return consultations;
    }

    public List<Consultation> getAllConsultationsSorted() {
        List<Consultation> consultations = new ArrayList<>();
        consultationRepository.findAllByOrderByConsultationDateAsc().forEach(consultations::add);
        return consultations;
    }

    public Consultation getConsultation(Integer consultationId) {
        return  consultationRepository.findById(consultationId).get();
    }

    public void addConsultation(Consultation consultation) {
        consultationRepository.save(consultation);
    }

}

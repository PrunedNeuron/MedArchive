package dev.ayushm.med.service;

import dev.ayushm.med.model.*;
import dev.ayushm.med.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    private static final Logger logger = LoggerFactory.getLogger(PatientService.class);

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    @Autowired
    private TreatmentRepository treatmentRepository;

    @Autowired
    private DrugRepository drugRepository;

    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        patientRepository.findAll().forEach(patients::add);
        return patients;
    }

    public Patient getPatient(Integer patientId) {
        return  patientRepository.findById(patientId).get();
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Consultation> getConsultations(Integer patientId) {
        List<Consultation> consultations = consultationRepository.findAllByPatientId(patientId);

        return consultations;
    }

    public List<String> search(String keyword) {
        logger.info("SEARCH RESULT = " + patientRepository.findByPatientNameContaining(keyword));
        return patientRepository.findByPatientNameContaining(keyword).stream().map(object -> object.getPatientName()).collect(Collectors.toList());
    }

    public List<Diagnosis> getDiagnoses(Integer patientId) {
        List<Diagnosis> diagnoses = new ArrayList<>();
        diagnosisRepository.findAll().forEach(diagnosis -> {
            if (diagnosis.getConsultation().getPatientId() == patientId)
                diagnoses.add(diagnosis);
        });

        return diagnoses;
    }

    public List<Treatment> getTreatments(Integer patientId) {
        List<Treatment> treatments = new ArrayList<>();
        treatmentRepository.findAll().forEach(treatment -> {
            if (treatment.getDiagnosis().getConsultation().getPatientId() == patientId)
                treatments.add(treatment);
        });

        return treatments;
    }

    public List<Drug> getDrugs(Integer patientId) {
        List<Drug> drugs = new ArrayList<>();

        treatmentRepository.findAll().forEach(treatment -> {
           if (treatment.getDiagnosis().getConsultation().getPatientId() == patientId)
               drugs.add(treatment.getDrug());
        });

        return drugs;
    }

    public List<Illness> getIllnesses(Integer patientId) {
        List<Illness> illnesses = new ArrayList<>();
        diagnosisRepository.findAll().forEach(diagnosis -> {
            if (diagnosis.getConsultation().getPatientId() == patientId)
                illnesses.add(diagnosis.getIllness());
        });

        return illnesses;
    }

    public List<Patient> getPatientsByName(String name) {
        return patientRepository.findByPatientNameContaining(name);
    }

}

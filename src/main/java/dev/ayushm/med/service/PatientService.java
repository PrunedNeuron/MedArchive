package dev.ayushm.med.service;

import dev.ayushm.med.model.*;
import dev.ayushm.med.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

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

    public void addPatient(Patient patient) {
        patientRepository.save(patient);
    }

    public List<Consultation> getConsultations(Integer patientId) {
        List<Consultation> consultations = consultationRepository.findAllByPatientId(patientId);

        return consultations;
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

}

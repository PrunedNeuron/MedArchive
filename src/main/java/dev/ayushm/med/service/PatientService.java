package dev.ayushm.med.service;

import dev.ayushm.med.model.*;
import dev.ayushm.med.repository.ConsultationRepository;
import dev.ayushm.med.repository.DiagnosisRepository;
import dev.ayushm.med.repository.PatientRepository;
import dev.ayushm.med.repository.TreatmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    private static final Logger log = LoggerFactory.getLogger(PatientService.class);

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    @Autowired
    private TreatmentRepository treatmentRepository;

    public List<Patient> getAllPatients() {
        log.info("Retrieving list of all patients from the repository...");
        List<Patient> patients = new ArrayList<>();
        patientRepository.findAll().forEach(patients::add);

        return patients;
    }

    public Patient getPatient(Integer patientId) {
        log.info("Retrieving patient with given patient ID from the repository...");
        return patientRepository.findById(patientId).get();
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deletePatient(Integer patientId) {
        patientRepository.deleteById(patientId);
    }

    public List<Consultation> getConsultations(Integer patientId) {
        List<Consultation> consultations = consultationRepository.findAllByPatientId(patientId);
        return consultations;
    }

    public List<String> search(String keyword) {
        log.info("Searching for patients with a matching name...");
        return patientRepository
                .findByPatientNameContaining(keyword)
                .stream()
                .map(patient -> patient.getPatientName())
                .collect(Collectors.toList());
    }

    public List<Diagnosis> getDiagnoses(Integer patientId) {
        log.info("Retrieving given patient's diagnoses from the repository...");
        List<Diagnosis> diagnoses = new ArrayList<>();
        diagnosisRepository.findAll().forEach(diagnosis -> {
            if (diagnosis.getConsultation().getPatientId().equals(patientId))
                diagnoses.add(diagnosis);
        });

        return diagnoses;
    }

    public List<Treatment> getTreatments(Integer patientId) {
        log.info("Retrieving given patient's treatments from the repository...");
        List<Treatment> treatments = new ArrayList<>();
        treatmentRepository.findAll().forEach(treatment -> {
            if (treatment.getDiagnosis().getConsultation().getPatientId().equals(patientId))
                treatments.add(treatment);
        });

        return treatments;
    }

    public List<Drug> getDrugs(Integer patientId) {
        log.info("Retrieving given patient's prescribed drugs from the repository...");
        List<Drug> drugs = new ArrayList<>();
        treatmentRepository.findAll().forEach(treatment -> {
            if (treatment.getDiagnosis().getConsultation().getPatientId().equals(patientId))
                drugs.add(treatment.getDrug());
        });

        return drugs;
    }

    public List<Illness> getIllnesses(Integer patientId) {
        List<Illness> illnesses = new ArrayList<>();
        diagnosisRepository.findAll().forEach(diagnosis -> {
            if (diagnosis.getConsultation().getPatientId().equals(patientId))
                illnesses.add(diagnosis.getIllness());
        });

        return illnesses;
    }

    public List<Patient> getPatientsByName(String name) {
        return patientRepository.findByPatientNameContaining(name);
    }

}

package dev.ayushm.med.service;

import dev.ayushm.med.model.Patient;
import dev.ayushm.med.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

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

}

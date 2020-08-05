package dev.ayushm.med.repository;

import dev.ayushm.med.model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {

    List<Patient> findByPatientNameContaining(String query);

}

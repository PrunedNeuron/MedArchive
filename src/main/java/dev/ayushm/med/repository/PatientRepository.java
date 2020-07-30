package dev.ayushm.med.repository;

import dev.ayushm.med.model.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Integer> {
}

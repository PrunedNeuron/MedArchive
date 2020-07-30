package dev.ayushm.med.repository;

import dev.ayushm.med.model.Diagnosis;
import org.springframework.data.repository.CrudRepository;

public interface DiagnosisRepository extends CrudRepository<Diagnosis, Integer> {
}

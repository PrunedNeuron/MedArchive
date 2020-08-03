package dev.ayushm.med.repository;

import dev.ayushm.med.model.Diagnosis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosisRepository extends CrudRepository<Diagnosis, Integer> {
}

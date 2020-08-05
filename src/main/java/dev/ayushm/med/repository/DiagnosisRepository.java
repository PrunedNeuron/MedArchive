package dev.ayushm.med.repository;

import dev.ayushm.med.model.Diagnosis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiagnosisRepository extends CrudRepository<Diagnosis, Integer> {
    List<Diagnosis> findAllByConsultationId(Integer consultationId);
}

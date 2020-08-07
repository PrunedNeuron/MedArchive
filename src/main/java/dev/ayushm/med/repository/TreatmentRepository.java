package dev.ayushm.med.repository;

import dev.ayushm.med.model.Treatment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TreatmentRepository extends CrudRepository<Treatment, Integer> {
    Set<Treatment> findAllByOrderByDiagnosis_Consultation_ConsultationDateDesc();
}

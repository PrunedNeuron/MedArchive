package dev.ayushm.med.repository;

import dev.ayushm.med.model.Consultation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultationRepository extends CrudRepository<Consultation, Integer> {
    List<Consultation> findAllByOrderByConsultationDateDesc();

    List<Consultation> findAllByPatientId(Integer patientId);
}

package dev.ayushm.med.repository;

import dev.ayushm.med.model.Consultation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConsultationRepository extends CrudRepository<Consultation, Integer> {
    List<Consultation> findAllByOrderByConsultationDateAsc();
    List<Consultation> findAllByPatientId(Integer patientId);
}

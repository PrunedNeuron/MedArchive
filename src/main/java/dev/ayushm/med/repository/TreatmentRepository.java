package dev.ayushm.med.repository;

import dev.ayushm.med.model.Treatment;
import org.springframework.data.repository.CrudRepository;

public interface TreatmentRepository extends CrudRepository<Treatment, Integer> {
}

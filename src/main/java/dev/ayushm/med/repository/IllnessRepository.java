package dev.ayushm.med.repository;

import dev.ayushm.med.model.Illness;
import org.springframework.data.repository.CrudRepository;

public interface IllnessRepository extends CrudRepository<Illness, Integer> {
}

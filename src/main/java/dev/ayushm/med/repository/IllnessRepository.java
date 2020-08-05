package dev.ayushm.med.repository;

import dev.ayushm.med.model.Illness;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IllnessRepository extends CrudRepository<Illness, Integer> {
    List<Illness> findByIllnessNameContaining(String query);
}

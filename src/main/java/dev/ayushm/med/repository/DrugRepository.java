package dev.ayushm.med.repository;

import dev.ayushm.med.model.Drug;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugRepository extends CrudRepository<Drug, Integer> {
}

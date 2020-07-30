package dev.ayushm.med.repository;

import dev.ayushm.med.model.Drug;
import org.springframework.data.repository.CrudRepository;

public interface DrugRepository extends CrudRepository<Drug, Integer> {
}

package dev.ayushm.med.repository;

import dev.ayushm.med.model.Test;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends CrudRepository<Test, Integer> {
    List<Test> findByTestNameContaining(String query);
}

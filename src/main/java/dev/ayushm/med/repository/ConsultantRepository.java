package dev.ayushm.med.repository;

import dev.ayushm.med.model.Consultant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultantRepository extends CrudRepository<Consultant, Integer> {

    List<Consultant> findByConsultantNameContaining(String query);

}

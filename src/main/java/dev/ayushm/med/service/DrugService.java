package dev.ayushm.med.service;

import dev.ayushm.med.model.Drug;
import dev.ayushm.med.repository.DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DrugService {

    @Autowired
    private DrugRepository drugRepository;

    public List<Drug> getAllDrugs() {
        List<Drug> drugs = new ArrayList<>();
        drugRepository.findAll().forEach(drugs::add);
        return drugs;
    }

    public void addDrug(Drug drug) {
        drugRepository.save(drug);
    }

}

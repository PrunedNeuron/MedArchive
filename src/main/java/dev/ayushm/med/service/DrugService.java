package dev.ayushm.med.service;

import dev.ayushm.med.model.Drug;
import dev.ayushm.med.repository.DrugRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DrugService {

    private static final Logger log = LoggerFactory.getLogger(DrugService.class);

    private final DrugRepository drugRepository;

    public DrugService(DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }

    public List<Drug> getAllDrugs() {
        List<Drug> drugs = new ArrayList<>();
        drugRepository.findAll().forEach(drugs::add);
        return drugs;
    }

    public Drug getDrug(Integer drugId) {
        return drugRepository.findById(drugId).orElse(null);
    }

    public Drug addDrug(Drug drug) {
        return drugRepository.save(drug);
    }

    public List<Drug> getDrugsByName(String name) {
        return drugRepository.findByDrugNameContaining(name);
    }

    public List<String> search(String keyword) {
        log.info("Searching for a drug with a matching name...");
        return drugRepository
                .findByDrugNameContaining(keyword)
                .stream()
                .map(Drug::getDrugName)
                .collect(Collectors.toList());
    }

}

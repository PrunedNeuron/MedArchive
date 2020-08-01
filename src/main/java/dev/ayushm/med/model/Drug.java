package dev.ayushm.med.model;

import javax.persistence.*;

@Entity
@Table(name = "drug")
public class Drug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drug_id")
    private Integer drugId;

    @Column(name = "drug_name")
    private String drugName;

    public Drug() {
    }

    public Drug(Integer drugId, String drugName) {
        this.drugId = drugId;
        this.drugName = drugName;
    }

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }
}

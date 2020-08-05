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

    @Column(name = "drug_classification", length = 1000)
    private String drugClassification;

    @Column(name = "drug_mechanism", length = 3000)
    private String drugMechanism;

    public Drug() {
    }

    public Drug(Integer drugId, String drugName, String drugClassification, String drugMechanism) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.drugClassification = drugClassification;
        this.drugMechanism = drugMechanism;
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

    public String getDrugClassification() {
        return drugClassification;
    }

    public void setDrugClassification(String drugClassification) {
        this.drugClassification = drugClassification;
    }

    public String getDrugMechanism() {
        return drugMechanism;
    }

    public void setDrugMechanism(String drugMechanism) {
        this.drugMechanism = drugMechanism;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "drugId=" + drugId +
                ", drugName='" + drugName + '\'' +
                ", drugClassification='" + drugClassification + '\'' +
                ", drugMechanism='" + drugMechanism + '\'' +
                '}';
    }

}

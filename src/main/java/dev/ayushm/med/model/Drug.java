package dev.ayushm.med.model;

import javax.persistence.*;

@Entity
@Table(name = "drug")
public class Drug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drug_id")
    private Integer drugId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "treatment_id",
            referencedColumnName = "treatment_id",
            insertable = false,
            updatable = false)
    private Treatment treatment;

    @Column(name = "treatment_id")
    private Integer treatmentId;

    @Column(name = "drug_name")
    private String drugName;

    @Column(name = "drug_classification", length = 1000)
    private String drugClassification;

    @Column(name = "drug_mechanism", length = 3000)
    private String drugMechanism;

    public Drug() {
    }

    public Drug(Integer drugId, Treatment treatment, Integer treatmentId, String drugName, String drugClassification, String drugMechanism) {
        this.drugId = drugId;
        this.treatment = treatment;
        this.treatmentId = treatmentId;
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

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public Integer getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(Integer treatmentId) {
        this.treatmentId = treatmentId;
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
                ", treatment=" + treatment +
                ", treatmentId=" + treatmentId +
                ", drugName='" + drugName + '\'' +
                ", drugClassification='" + drugClassification + '\'' +
                ", drugMechanism='" + drugMechanism + '\'' +
                '}';
    }

}

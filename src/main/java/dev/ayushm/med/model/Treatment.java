package dev.ayushm.med.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "treatment")
public class Treatment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "treatment_id")
    private Integer treatmentId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "diagnosis_id",
            referencedColumnName = "diagnosis_id",
            insertable = false,
            updatable = false)
    private Diagnosis diagnosis;

    @Column(name = "diagnosis_id")
    private Integer diagnosisId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "drug_id",
            referencedColumnName = "drug_id",
            insertable = false,
            updatable = false)
    private Drug drug;

    @Column(name = "drug_id")
    private Integer drugId;

    public Treatment() {
    }

    public Treatment(Integer treatmentId, Diagnosis diagnosis, Integer diagnosisId, Drug drug, Integer drugId) {
        this.treatmentId = treatmentId;
        this.diagnosis = diagnosis;
        this.diagnosisId = diagnosisId;
        this.drug = drug;
        this.drugId = drugId;
    }

    public Integer getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(Integer treatmentId) {
        this.treatmentId = treatmentId;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Integer getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(Integer diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }

    @Override
    public String toString() {
        return "Treatment{" +
                "treatmentId=" + treatmentId +
                ", diagnosis=" + diagnosis +
                ", diagnosisId=" + diagnosisId +
                ", drug=" + drug +
                ", drugId=" + drugId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Treatment treatment = (Treatment) o;
        return Objects.equals(diagnosis, treatment.diagnosis) &&
                Objects.equals(diagnosisId, treatment.diagnosisId) &&
                Objects.equals(drug, treatment.drug) &&
                Objects.equals(drugId, treatment.drugId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(diagnosis, diagnosisId, drug, drugId);
    }

}

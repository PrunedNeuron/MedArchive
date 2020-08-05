package dev.ayushm.med.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "diagnosis")
public class Diagnosis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diagnosis_id")
    private Integer diagnosisId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "consultation_id",
            referencedColumnName = "consultation_id",
            insertable = false,
            updatable = false)
    private Consultation consultation;

    @Column(name = "consultation_id")
    private Integer consultationId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "illness_id",
            referencedColumnName = "illness_id",
            insertable = false,
            updatable = false)
    private Illness illness;

    @Column(name = "illness_id")
    private Integer illnessId;

    public Diagnosis() {
    }

    public Diagnosis(Integer diagnosisId, Consultation consultation, Integer consultationId, Illness illness, Integer illnessId) {
        this.diagnosisId = diagnosisId;
        this.consultation = consultation;
        this.consultationId = consultationId;
        this.illness = illness;
        this.illnessId = illnessId;
    }

    public Integer getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(Integer diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public Integer getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(Integer consultationId) {
        this.consultationId = consultationId;
    }

    public Illness getIllness() {
        return illness;
    }

    public void setIllness(Illness illness) {
        this.illness = illness;
    }

    public Integer getIllnessId() {
        return illnessId;
    }

    public void setIllnessId(Integer illnessId) {
        this.illnessId = illnessId;
    }

    @Override
    public String toString() {
        return "Diagnosis{" +
                "diagnosisId=" + diagnosisId +
                ", consultation=" + consultation +
                ", consultationId=" + consultationId +
                ", illness=" + illness +
                ", illnessId=" + illnessId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diagnosis diagnosis = (Diagnosis) o;
        return Objects.equals(consultation, diagnosis.consultation) &&
                Objects.equals(consultationId, diagnosis.consultationId) &&
                Objects.equals(illness, diagnosis.illness) &&
                Objects.equals(illnessId, diagnosis.illnessId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(consultation, consultationId, illness, illnessId);
    }
}

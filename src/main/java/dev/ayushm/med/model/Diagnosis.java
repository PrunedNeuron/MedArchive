package dev.ayushm.med.model;

import javax.persistence.*;

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
}

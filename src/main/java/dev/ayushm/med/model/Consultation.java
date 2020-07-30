package dev.ayushm.med.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consultation_id")
    private Integer consultationId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id",
                referencedColumnName = "patient_id",
                insertable = false,
                updatable = false)
    private Patient patient;

    @Column(name = "patient_id")
    private Integer patientId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "consultant_id",
            referencedColumnName = "consultant_id",
            insertable = false,
            updatable = false)
    private Consultant consultant;

    @Column(name = "consultant_id")
    private Integer consultantId;

    @Column(name = "consultation_location")
    private String consultationLocation;

    @Column(name = "consultation_date")
    private Date consultationDate;

    public Consultation() {
    }

    public Consultation(Integer consultationId, Patient patient, Integer patientId, Consultant consultant, Integer consultantId, String consultationLocation, Date consultationDate) {
        this.consultationId = consultationId;
        this.patient = patient;
        this.patientId = patientId;
        this.consultant = consultant;
        this.consultantId = consultantId;
        this.consultationLocation = consultationLocation;
        this.consultationDate = consultationDate;
    }

    public Integer getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(Integer consultationId) {
        this.consultationId = consultationId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Consultant getConsultant() {
        return consultant;
    }

    public void setConsultant(Consultant consultant) {
        this.consultant = consultant;
    }

    public Integer getConsultantId() {
        return consultantId;
    }

    public void setConsultantId(Integer consultantId) {
        this.consultantId = consultantId;
    }

    public String getConsultationLocation() {
        return consultationLocation;
    }

    public void setConsultationLocation(String consultationLocation) {
        this.consultationLocation = consultationLocation;
    }

    public Date getConsultationDate() {
        return consultationDate;
    }

    public void setConsultationDate(Date consultationDate) {
        this.consultationDate = consultationDate;
    }
}

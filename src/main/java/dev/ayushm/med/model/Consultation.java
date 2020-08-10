package dev.ayushm.med.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "consultation")
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "test_id",
            referencedColumnName = "test_id",
            insertable = false,
            updatable = false)
    private Test test;

    @Column(name = "test_id")
    private Integer testId;

    @Column(name = "consultation_location")
    private String consultationLocation;

    @Column(name = "consultation_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date consultationDate;

    public Consultation() {
    }

    public Consultation(Integer consultationId, Patient patient, Integer patientId, Consultant consultant, Integer consultantId, Test test, Integer testId, String consultationLocation, Date consultationDate) {
        this.consultationId = consultationId;
        this.patient = patient;
        this.patientId = patientId;
        this.consultant = consultant;
        this.consultantId = consultantId;
        this.test = test;
        this.testId = testId;
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

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
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

    @Override
    public String toString() {
        return "Consultation{" +
                "consultationId=" + consultationId +
                ", patient=" + patient +
                ", patientId=" + patientId +
                ", consultant=" + consultant +
                ", consultantId=" + consultantId +
                ", test=" + test +
                ", testId=" + testId +
                ", consultationLocation='" + consultationLocation + '\'' +
                ", consultationDate=" + consultationDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consultation that = (Consultation) o;
        return Objects.equals(patient, that.patient) &&
                Objects.equals(patientId, that.patientId) &&
                Objects.equals(consultant, that.consultant) &&
                Objects.equals(consultantId, that.consultantId) &&
                Objects.equals(test, that.test) &&
                Objects.equals(testId, that.testId) &&
                Objects.equals(consultationLocation, that.consultationLocation) &&
                Objects.equals(consultationDate, that.consultationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patient, patientId, consultant, consultantId, test, testId, consultationLocation, consultationDate);
    }
}

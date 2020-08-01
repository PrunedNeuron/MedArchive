package dev.ayushm.med.model;

import javax.persistence.*;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Integer patientId;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "patient_email")
    private String patientEmail;

    @Column(name = "patient_phone")
    private String patientPhone;

    @Column(name = "patient_age")
    private Integer patientAge;

    @Column(name = "patient_gender")
    private String patientGender;

    @Column(name = "patient_allergic_to")
    private String patientAllergicTo;

    public Patient() {
    }

    public Patient(Integer patientId, String patientName, String patientEmail, String patientPhone, Integer patientAge, String patientGender, String patientAllergicTo) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientEmail = patientEmail;
        this.patientPhone = patientPhone;
        this.patientAge = patientAge;
        this.patientGender = patientGender;
        this.patientAllergicTo = patientAllergicTo;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public Integer getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(Integer patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public String getPatientAllergicTo() {
        return patientAllergicTo;
    }

    public void setPatientAllergicTo(String patientAllergicTo) {
        this.patientAllergicTo = patientAllergicTo;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", patientEmail='" + patientEmail + '\'' +
                ", patientPhone='" + patientPhone + '\'' +
                ", patientAge=" + patientAge +
                ", patientGender='" + patientGender + '\'' +
                ", patientAllergicTo='" + patientAllergicTo + '\'' +
                '}';
    }
}

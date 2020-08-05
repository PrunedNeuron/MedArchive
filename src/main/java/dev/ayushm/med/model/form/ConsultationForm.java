package dev.ayushm.med.model.form;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ConsultationForm {

    private String patientName;
    private String consultantName;
    private String consultationLocation;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date consultationDate;

    private String illnessName;
    private String drugName;

    private String testName;
    private String testValue;

    public ConsultationForm() {
    }

    public ConsultationForm(String patientName, String consultantName, String consultationLocation, Date consultationDate, String illnessName, String drugName, String testName, String testValue) {
        this.patientName = patientName;
        this.consultantName = consultantName;
        this.consultationLocation = consultationLocation;
        this.consultationDate = consultationDate;
        this.illnessName = illnessName;
        this.drugName = drugName;
        this.testName = testName;
        this.testValue = testValue;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getConsultantName() {
        return consultantName;
    }

    public void setConsultantName(String consultantName) {
        this.consultantName = consultantName;
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

    public String getIllnessName() {
        return illnessName;
    }

    public void setIllnessName(String illnessName) {
        this.illnessName = illnessName;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestValue() {
        return testValue;
    }

    public void setTestValue(String testValue) {
        this.testValue = testValue;
    }
}

package dev.ayushm.med.model.form;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "ConsultationForm{" +
                "patientName='" + patientName + '\'' +
                ", consultantName='" + consultantName + '\'' +
                ", consultationLocation='" + consultationLocation + '\'' +
                ", consultationDate=" + consultationDate +
                ", illnessName='" + illnessName + '\'' +
                ", drugName='" + drugName + '\'' +
                ", testName='" + testName + '\'' +
                ", testValue='" + testValue + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsultationForm that = (ConsultationForm) o;
        return Objects.equals(patientName, that.patientName) &&
                Objects.equals(consultantName, that.consultantName) &&
                Objects.equals(consultationLocation, that.consultationLocation) &&
                Objects.equals(consultationDate, that.consultationDate) &&
                Objects.equals(illnessName, that.illnessName) &&
                Objects.equals(drugName, that.drugName) &&
                Objects.equals(testName, that.testName) &&
                Objects.equals(testValue, that.testValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientName, consultantName, consultationLocation, consultationDate, illnessName, drugName, testName, testValue);
    }

}

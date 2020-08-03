package dev.ayushm.med.model;

import javax.persistence.*;

@Entity
@Table(name = "test")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    private Integer testId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "consultation_id",
            referencedColumnName = "consultation_id",
            insertable = false,
            updatable = false)
    private Consultation consultation;

    @Column(name = "consultation_id")
    private Integer consultationId;

    @Column(name = "test_name")
    private String testName;

    @Column(name = "test_value")
    private String testValue;

    public Test() {
    }

    public Test(Integer testId, Consultation consultation, Integer consultationId, String testName, String testValue) {
        this.testId = testId;
        this.consultation = consultation;
        this.consultationId = consultationId;
        this.testName = testName;
        this.testValue = testValue;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
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
        return "Test{" +
                "testId=" + testId +
                ", consultation=" + consultation +
                ", consultationId=" + consultationId +
                ", testName='" + testName + '\'' +
                ", testValue='" + testValue + '\'' +
                '}';
    }

}

package dev.ayushm.med.model;

import javax.persistence.*;

@Entity
@Table(name = "test")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    private Integer testId;

    @Column(name = "test_name")
    private String testName;

    @Column(name = "test_value")
    private String testValue;

    public Test() {
    }

    public Test(Integer testId, String testName, String testValue) {
        this.testId = testId;
        this.testName = testName;
        this.testValue = testValue;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
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

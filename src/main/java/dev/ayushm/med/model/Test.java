package dev.ayushm.med.model;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "Test{" +
                "testId=" + testId +
                ", testName='" + testName + '\'' +
                ", testValue='" + testValue + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return Objects.equals(testName, test.testName) &&
                Objects.equals(testValue, test.testValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(testName, testValue);
    }
}

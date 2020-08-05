package dev.ayushm.med.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "consultant")
public class Consultant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consultant_id")
    private Integer consultantId;

    @Column(name = "consultant_name")
    private String consultantName;

    @Column(name = "consultant_email")
    private String consultantEmail;

    @Column(name = "consultant_phone")
    private String consultantPhone;

    @Column(name = "consultant_specialty")
    private String consultantSpecialty;

    @Column(name = "consultant_experience")
    private Integer consultantExperience;

    public Consultant() {

    }

    public Consultant(Integer consultantId, String consultantName, String consultantEmail, String consultantPhone, String consultantSpecialty, Integer consultantExperience) {
        this.consultantId = consultantId;
        this.consultantName = consultantName;
        this.consultantEmail = consultantEmail;
        this.consultantPhone = consultantPhone;
        this.consultantSpecialty = consultantSpecialty;
        this.consultantExperience = consultantExperience;
    }

    public Integer getConsultantId() {
        return consultantId;
    }

    public void setConsultantId(Integer consultantId) {
        this.consultantId = consultantId;
    }

    public String getConsultantName() {
        return consultantName;
    }

    public void setConsultantName(String consultantName) {
        this.consultantName = consultantName;
    }

    public String getConsultantEmail() {
        return consultantEmail;
    }

    public void setConsultantEmail(String consultantEmail) {
        this.consultantEmail = consultantEmail;
    }

    public String getConsultantPhone() {
        return consultantPhone;
    }

    public void setConsultantPhone(String consultantPhone) {
        this.consultantPhone = consultantPhone;
    }

    public String getConsultantSpecialty() {
        return consultantSpecialty;
    }

    public void setConsultantSpecialty(String consultantSpecialty) {
        this.consultantSpecialty = consultantSpecialty;
    }

    public Integer getConsultantExperience() {
        return consultantExperience;
    }

    public void setConsultantExperience(Integer consultantExperience) {
        this.consultantExperience = consultantExperience;
    }

    @Override
    public String toString() {
        return "Consultant{" +
                "consultantId=" + consultantId +
                ", consultantName='" + consultantName + '\'' +
                ", consultantEmail='" + consultantEmail + '\'' +
                ", consultantPhone='" + consultantPhone + '\'' +
                ", consultantSpecialty='" + consultantSpecialty + '\'' +
                ", consultantExperience=" + consultantExperience +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consultant that = (Consultant) o;
        return Objects.equals(consultantName, that.consultantName) &&
                Objects.equals(consultantEmail, that.consultantEmail) &&
                Objects.equals(consultantPhone, that.consultantPhone) &&
                Objects.equals(consultantSpecialty, that.consultantSpecialty) &&
                Objects.equals(consultantExperience, that.consultantExperience);
    }

    @Override
    public int hashCode() {
        return Objects.hash(consultantName, consultantEmail, consultantPhone, consultantSpecialty, consultantExperience);
    }
}

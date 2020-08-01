package dev.ayushm.med.model;

import javax.persistence.*;

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

    public Consultant() {

    }

    public Consultant(Integer consultantId, String consultantName, String consultantEmail, String consultantPhone) {
        this.consultantId = consultantId;
        this.consultantName = consultantName;
        this.consultantEmail = consultantEmail;
        this.consultantPhone = consultantPhone;
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
}

package dev.ayushm.med.model;

import javax.persistence.*;

@Entity
@Table(name = "illness")
public class Illness {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "illness_id")
    private Integer illnessId;

    @Column(name = "illness_name")
    private String illnessName;

    public Illness() {
    }

    public Illness(Integer illnessId, String illnessName) {
        this.illnessId = illnessId;
        this.illnessName = illnessName;
    }

    public Integer getIllnessId() {
        return illnessId;
    }

    public void setIllnessId(Integer illnessId) {
        this.illnessId = illnessId;
    }

    public String getIllnessName() {
        return illnessName;
    }

    public void setIllnessName(String illnessName) {
        this.illnessName = illnessName;
    }
}

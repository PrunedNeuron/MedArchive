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

    @Column(name = "illness_description")
    private String illnessDescription;

    @Column(name = "illness_symptoms")
    private String illnessSymptoms;

    public Illness() {
    }

    public Illness(Integer illnessId, String illnessName, String illnessDescription, String illnessSymptoms) {
        this.illnessId = illnessId;
        this.illnessName = illnessName;
        this.illnessDescription = illnessDescription;
        this.illnessSymptoms = illnessSymptoms;
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

    public String getIllnessDescription() {
        return illnessDescription;
    }

    public void setIllnessDescription(String illnessDescription) {
        this.illnessDescription = illnessDescription;
    }

    public String getIllnessSymptoms() {
        return illnessSymptoms;
    }

    public void setIllnessSymptoms(String illnessSymptoms) {
        this.illnessSymptoms = illnessSymptoms;
    }
}

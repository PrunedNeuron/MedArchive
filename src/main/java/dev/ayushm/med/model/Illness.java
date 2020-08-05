package dev.ayushm.med.model;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "Illness{" +
                "illnessId=" + illnessId +
                ", illnessName='" + illnessName + '\'' +
                ", illnessDescription='" + illnessDescription + '\'' +
                ", illnessSymptoms='" + illnessSymptoms + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Illness illness = (Illness) o;
        return Objects.equals(illnessName, illness.illnessName) &&
                Objects.equals(illnessDescription, illness.illnessDescription) &&
                Objects.equals(illnessSymptoms, illness.illnessSymptoms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(illnessName, illnessDescription, illnessSymptoms);
    }
}

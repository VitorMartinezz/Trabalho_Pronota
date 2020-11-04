package common.VO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tbStructure")
public class Structure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int activityQnt;
    private int periodQnt;
    private String structure;
    private int subjectQnt;
    private boolean formativa;
    private float average;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getActivityQnt() {
        return activityQnt;
    }

    public void setActivityQnt(int activityQnt) {
        this.activityQnt = activityQnt;
    }

    public int getPeriodQnt() {
        return periodQnt;
    }

    public void setPeriodQnt(int periodQnt) {
        this.periodQnt = periodQnt;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public int getSubjectQnt() {
        return subjectQnt;
    }

    public void setSubjectQnt(int subjectQnt) {
        this.subjectQnt = subjectQnt;
    }

    public boolean isFormativa() {
        return formativa;
    }

    public void setFormativa(boolean formativa) {
        this.formativa = formativa;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }
}

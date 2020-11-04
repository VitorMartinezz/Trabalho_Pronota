package common.VO;

import javax.persistence.*;

@Entity(name = "tbGradesUserSubject")
public class GradesUserSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private float grade;

    @ManyToOne(optional = false)
    private GradeTypes gradeTypes;

    @ManyToOne(optional = false)
    private UserSubject userSubject;

    @ManyToOne(optional = false)
    private Structure structure;

    private int sequence;
    private int periode;

    public UserSubject getUserSubject() {
        return userSubject;
    }

    public void setUserSubject(UserSubject userSubject) {
        this.userSubject = userSubject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public GradeTypes getGradeTypes() {
        return gradeTypes;
    }

    public void setGradeTypes(GradeTypes gradeTypes) {
        this.gradeTypes = gradeTypes;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public int getPeriode() {
        return periode;
    }

    public void setPeriode(int periode) {
        this.periode = periode;
    }
}

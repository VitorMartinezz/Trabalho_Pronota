package common.auxClasses;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;

public class GradesTableViewModel {
    public int getId() {
        return id;
    }

    private final int id;
    private final SimpleBooleanProperty selected;
    private final SimpleStringProperty subject;
    private final SimpleFloatProperty n11;
    private final SimpleFloatProperty n21;
    private final SimpleFloatProperty M1;
    private final SimpleFloatProperty n12;
    private final SimpleFloatProperty n22;
    private final SimpleFloatProperty AF;
    private final SimpleFloatProperty M2;

    public float getMF() {
        return (float) 0.12;
    }

    public SimpleFloatProperty MFProperty() {
        return MF;
    }

    private final SimpleFloatProperty MF;

    public boolean isSelected() {
        return selected.get();
    }

    public String getSubject() {
        return subject.get();
    }

    public SimpleStringProperty subjectProperty() {
        return subject;
    }

    public SimpleBooleanProperty selectedProperty() {
        return selected;
    }

    public float getN11() {
        return n11.get();
    }

    public SimpleFloatProperty n11Property() {
        return n11;
    }

    public float getN21() {
        return n21.get();
    }

    public SimpleFloatProperty n21Property() {
        return n21;
    }

    public float getM1() {
        return (float) ((getN11() * 0.4) + (getN21() * 0.6));
    }

    public SimpleFloatProperty m1Property() {
        return M1;
    }

    public float getN12() {
        return n12.get();
    }

    public SimpleFloatProperty n12Property() {
        return n12;
    }

    public float getN22() {
        return n22.get();
    }

    public SimpleFloatProperty n22Property() {
        return n22;
    }

    public float getAF() {
        return AF.get();
    }

    public SimpleFloatProperty AFProperty() {
        return AF;
    }

    public float getM2() {
        return (float) ((getN12() * 0.2) + (getAF() * 0.2) + (getN22() * 0.6));
    }

    public SimpleFloatProperty m2Property() {
        return M2;
    }

    public GradesTableViewModel(int id, Boolean selected, String subject, Float n11, Float n21, Float n12, Float n22, Float af) {
        this.id = id;
        this.selected = new SimpleBooleanProperty(selected);
        this.subject = new SimpleStringProperty(subject);
        this.n11 = new SimpleFloatProperty(n11);
        this.n21 = new SimpleFloatProperty(n21);
        M1 = new SimpleFloatProperty(0);
        this.n12 = new SimpleFloatProperty(n12);
        this.n22 = new SimpleFloatProperty(n22);
        AF = new SimpleFloatProperty(af);
        M2 = new SimpleFloatProperty(0);
        MF = new SimpleFloatProperty((float) ((((getN11() * 0.4) + (getN21() * 0.6)) * 0.5) + (((getN12() * 0.2) + (getAF() * 0.2) + (getN22() * 0.6)) * 0.5)));
    }


}

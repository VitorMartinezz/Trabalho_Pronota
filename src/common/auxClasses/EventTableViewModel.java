package common.auxClasses;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class EventTableViewModel {

    private final int id;
    private final SimpleStringProperty type_event;
    private final SimpleStringProperty subject;
    private final SimpleStringProperty date;

    public int getId() {
        return id;
    }

    public String getType_event() {
        return type_event.get();
    }

    public SimpleStringProperty type_eventProperty() {
        return type_event;
    }

    public String getSubject() {
        return subject.get();
    }

    public SimpleStringProperty subjectProperty() {
        return subject;
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public EventTableViewModel(int id, String type_event, String subject, String date) {
        this.id = id;
        this.type_event = new SimpleStringProperty(type_event);
        this.date = new SimpleStringProperty(date);
        this.subject = new SimpleStringProperty(subject);

    }
}

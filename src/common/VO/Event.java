package common.VO;

import common.generic.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Entity(name = "tbEvent")

public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(optional = false)
    private Subject subject;

    private Date event_date;

    @ManyToOne(optional = false)
    private EventTypes event_type;

    public int getId() {
        return id;
    }

    public void setId(int id) {this.id = id; }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Date getEvent_date() {
        return event_date;
    }

    public void setEvent_date(Date event_date) {
        this.event_date = event_date;
    }

    public EventTypes getEvent_type() {
        return event_type;
    }

    public void setEvent_type(EventTypes event_type) {
        this.event_type = event_type;
    }
}

package common.auxClasses;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ContentTableViewModel {
    private final int id;
    private final SimpleStringProperty title;
    private final SimpleStringProperty subject;
    private final SimpleStringProperty link;
    private final SimpleStringProperty fileName;
    private final SimpleIntegerProperty likes;
    private final byte[] content;

    public byte[] getContent() {
        return this.content;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public String getSubject() {
        return subject.get();
    }

    public SimpleStringProperty subjectProperty() {
        return subject;
    }

    public String getLink() {
        return link.get();
    }

    public SimpleStringProperty linkProperty() {
        return link;
    }

    public String getFileName() {
        return fileName.get();
    }

    public SimpleStringProperty fileNameProperty() {
        return fileName;
    }

    public int getLikes() {
        return likes.get();
    }

    public SimpleIntegerProperty likesProperty() {
        return likes;
    }

    public ContentTableViewModel(int id, String title, String subject, String link, String fileName, int likes, byte[] content) {
        this.id = id;
        this.title = new SimpleStringProperty(title);
        this.subject = new SimpleStringProperty(subject);
        this.link = new SimpleStringProperty(link);
        this.fileName = new SimpleStringProperty(fileName);
        this.likes = new SimpleIntegerProperty(likes);
        this.content = content;
    }
}

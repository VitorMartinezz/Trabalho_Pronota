package common.VO;

import common.generic.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "tbRoles")
public class Role extends model {
    @Id
    private int id;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

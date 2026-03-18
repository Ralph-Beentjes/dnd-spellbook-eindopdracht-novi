package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "classes")
public class ClassEntity extends BaseEntity {
    private String className;
    private String description;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

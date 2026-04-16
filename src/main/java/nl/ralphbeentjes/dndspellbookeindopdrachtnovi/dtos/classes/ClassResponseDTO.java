package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.classes;

import java.util.List;
import java.util.Set;

public class ClassResponseDTO {
    private Long id;
    private String className;
    private String description;
    private Set<Long> spellIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Set<Long> getSpellIds() {
        return spellIds;
    }

    public void setSpellIds(Set<Long> spellIds) {
        this.spellIds = spellIds;
    }
}

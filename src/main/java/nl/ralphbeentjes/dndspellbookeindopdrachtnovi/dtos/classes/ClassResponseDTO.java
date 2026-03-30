package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.classes;

import java.util.List;
import java.util.Set;

public class ClassResponseDTO {
    private Long id;
    private String className;
    private String description;

    private List<Long> spellbookIds;
    private Set<Long> spellIds;

    public Long getId() {
        return id;
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

    public List<Long> getSpellbookIds() {
        return spellbookIds;
    }

    public void setSpellbookIds(List<Long> spellbookIds) {
        this.spellbookIds = spellbookIds;
    }

    public Set<Long> getSpellIds() {
        return spellIds;
    }

    public void setSpellIds(Set<Long> spellIds) {
        this.spellIds = spellIds;
    }
}

package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.classes;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spellbooks.SpellbookResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class ClassRequestDTO {
    private String className;
    private String description;
    private List<Long> spellbookIds = new ArrayList<>();
    private List<Long> spellIds = new ArrayList<>();

    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<Long> getSpellbookIds() { return spellbookIds; }
    public void setSpellbookIds(List<Long> spellbookIds) { this.spellbookIds = spellbookIds; }

    public List<Long> getSpellIds() { return spellIds; }
    public void setSpellIds(List<Long> spellIds) { this.spellIds = spellIds; }
}

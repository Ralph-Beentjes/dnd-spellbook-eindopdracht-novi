package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.classes;

import java.util.List;
import java.util.Set;

public class ClassResponseDTO {
    private Long id;
    private String className;
    private String description;

    private List<SpellbookDTO> spellbooks;
    private Set<SpellDTO> spells;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<SpellbookDTO> getSpellbooks() { return spellbooks; }
    public void setSpellbooks(List<SpellbookDTO> spellbooks) { this.spellbooks = spellbooks; }

    public Set<SpellDTO> getSpells() { return spells; }
    public void setSpells(Set<SpellDTO> spells) { this.spells = spells; }
}

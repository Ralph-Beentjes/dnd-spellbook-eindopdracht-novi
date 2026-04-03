package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spells;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.classes.ClassResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spellbooks.SpellbookResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.enums.CastingTime;

import java.util.List;
import java.util.Set;

public class SpellResponseDTO {
    private Long id;
    private String spellName;
    private int level;
    private List<SpellbookResponseDTO> spellbooks;
    private List<ClassResponseDTO> classes;
    private CastingTime castingTime;
    private int range;
    private String components;
    private String duration;
    private boolean concentration;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpellName() {
        return spellName;
    }

    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<SpellbookResponseDTO> getSpellbooks() {
        return spellbooks;
    }

    public void setSpellbooks(List<SpellbookResponseDTO> spellbooks) {
        this.spellbooks = spellbooks;
    }

    public List<ClassResponseDTO> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassResponseDTO> classes) {
        this.classes = classes;
    }

    public CastingTime getCastingTime() {
        return castingTime;
    }

    public void setCastingTime(CastingTime castingTime) {
        this.castingTime = castingTime;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public String getComponents() {
        return components;
    }

    public void setComponents(String components) {
        this.components = components;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public boolean isConcentration() {
        return concentration;
    }

    public void setConcentration(boolean concentration) {
        this.concentration = concentration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

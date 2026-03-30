package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spells;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.classes.ClassResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.enums.CastingTime;

import java.util.Set;

public class SpellResponseDTO {
    private Long id;
    private String spellName;
    private int level;
    private Set<Long> spellbookIds;
    private Set<ClassResponseDTO> spellClasses;
    private CastingTime castingTime;
    private int range;
    private String components;
    private String duration;
    private boolean concentration;
    private String description;

    public Long getId() {
        return id;
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

    public Set<Long> getSpellbookIds() {
        return spellbookIds;
    }

    public void setSpellbookIds(Set<Long> spellbookIds) {
        this.spellbookIds = spellbookIds;
    }

    public Set<ClassResponseDTO> getSpellClasses() {
        return spellClasses;
    }

    public void setSpellClasses(Set<ClassResponseDTO> spellClasses) {
        this.spellClasses = spellClasses;
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

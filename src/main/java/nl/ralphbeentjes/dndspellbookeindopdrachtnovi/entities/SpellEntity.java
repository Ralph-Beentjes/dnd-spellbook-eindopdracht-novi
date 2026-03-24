package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities;

import jakarta.persistence.*;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.enums.CastingTime;

import java.util.List;

@Entity
@Table(name = "spells")
public class SpellEntity extends BaseEntity{
    @Column(unique = true, nullable = false)
    private String spellName;
    private int level;

    @ManyToMany(mappedBy = "spells")
    private List<SpellbookEntity> spellbooks;

    @ManyToMany(mappedBy = "spells")
    private List<ClassEntity> classes;

    @Enumerated(EnumType.STRING)
    private CastingTime castingTime;

    @Column(nullable = false)
    private int range;

    @Column(nullable = false, length = 100)
    private String components;

    @Column(nullable = false, length = 100)
    private String duration;

    private boolean concentration;

    @Column(nullable = false)
    private String description;

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

    public List<SpellbookEntity> getSpellbooks() {
        return spellbooks;
    }

    public void setSpellbooks(List<SpellbookEntity> spellbooks) {
        this.spellbooks = spellbooks;
    }

    public List<ClassEntity> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassEntity> classes) {
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

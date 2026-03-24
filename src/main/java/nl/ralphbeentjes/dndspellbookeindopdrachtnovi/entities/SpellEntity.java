package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities;

import jakarta.persistence.*;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.enums.CastingTime;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "spells")
public class SpellEntity extends BaseEntity{
    @Column(unique = true, nullable = false)
    private String spellName;
    private int level;

    @ManyToMany(mappedBy = "spells", fetch = FetchType.LAZY)
    private Set<SpellbookEntity> spellbooks = new HashSet<>();

    @ManyToMany(mappedBy = "spells", fetch = FetchType.LAZY)
    private Set<ClassEntity> characterClasses = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private CastingTime castingTime;

    @Column(nullable = false)
    private int range;

    @Column(nullable = false, length = 100)
    private String components;

    @Column(nullable = false, length = 100)
    private String duration;

    private boolean concentration;

    @Column(nullable = false, columnDefinition = "TEXT")
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

    public Set<SpellbookEntity> getSpellbooks() {
        return spellbooks;
    }

    public void setSpellbooks(Set<SpellbookEntity> spellbooks) {
        this.spellbooks = spellbooks;
    }

    public Set<ClassEntity> getClasses() {
        return characterClasses;
    }

    public void setClasses(Set<ClassEntity> classes) {
        this.characterClasses = classes;
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

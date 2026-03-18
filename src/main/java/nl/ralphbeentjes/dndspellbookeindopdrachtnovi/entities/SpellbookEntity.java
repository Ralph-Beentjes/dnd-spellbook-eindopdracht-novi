package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "spellbooks")
public class SpellbookEntity extends BaseEntity {
    private String spellbookName;
    private int level;

    private ClassEntity characterClass;

    private List<SpellEntity> spells;

    public String getSpellbookName() {
        return spellbookName;
    }

    public void setSpellbookName(String spellbookName) {
        this.spellbookName = spellbookName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public ClassEntity getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(ClassEntity characterClass) {
        this.characterClass = characterClass;
    }

    public List<SpellEntity> getSpells() {
        return spells;
    }

    public void setSpells(List<SpellEntity> spells) {
        this.spells = spells;
    }
}

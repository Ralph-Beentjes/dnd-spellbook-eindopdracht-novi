package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "classes")
public class ClassEntity extends BaseEntity {
    @Column(unique = true, nullable = false, length = 100)
    private String className;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "characterClass", fetch = FetchType.LAZY)
    private List<SpellbookEntity> spellbooks;

    @ManyToMany (fetch = FetchType.LAZY)
    @JoinTable(
            name = "class_spell",
            joinColumns = @JoinColumn (name = "class_id"),
            inverseJoinColumns = @JoinColumn (name = "spell_id")
    )
    private Set<SpellEntity> spells = new HashSet<>();

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

    public List<SpellbookEntity> getSpellbooks() {
        return spellbooks;
    }

    public void setSpellbooks(List<SpellbookEntity> spellbooks) {
        this.spellbooks = spellbooks;
    }

    public Set<SpellEntity> getSpells() {
        return spells;
    }

    public void setSpells(Set<SpellEntity> spells) {
        this.spells = spells;
    }
}

package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "classes")
public class ClassEntity extends BaseEntity {
    @Column(unique = true, nullable = false, length = 100)
    private String className;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "classes")
    private List<SpellbookEntity> spellbooks;

    @ManyToMany
    @JoinTable(
            name = "class_spell",
            joinColumns = @JoinColumn (name = "class-id"),
            inverseJoinColumns = @JoinColumn (name = "spell-id")
    )
    private List<SpellEntity> spells;

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

    public List<SpellEntity> getSpells() {
        return spells;
    }

    public void setSpells(List<SpellEntity> spells) {
        this.spells = spells;
    }
}

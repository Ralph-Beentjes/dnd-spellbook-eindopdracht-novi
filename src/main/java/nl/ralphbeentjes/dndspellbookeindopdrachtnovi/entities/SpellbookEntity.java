package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "spellbooks")
public class SpellbookEntity extends BaseEntity {
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "user-id")
    private UserProfileEntity user;

    @Column(length = 100)
    private String spellbookName;

    private int level;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id", nullable = false)
    private ClassEntity characterClass;

    @ManyToMany (fetch = FetchType.LAZY)
    @JoinTable(
            name = "spellbook_spell",
            joinColumns = @JoinColumn(name= "spellbook_id"),
            inverseJoinColumns = @JoinColumn(name = "spell_id")
    )
    private Set<SpellEntity> spells;

    @OneToMany(mappedBy = "spellbook", fetch = FetchType.LAZY)
    private List<ShareEntity> shares;

    public UserProfileEntity getUser() {
        return user;
    }

    public void setUser(UserProfileEntity user) {
        this.user = user;
    }

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

    public Set<SpellEntity> getSpells() {
        return spells;
    }

    public void setSpells(Set<SpellEntity> spells) {
        this.spells = spells;
    }

    public List<ShareEntity> getShares() {
        return shares;
    }

    public void setShares(List<ShareEntity> shares) {
        this.shares = shares;
    }
}

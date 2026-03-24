package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "spellbooks")
public class SpellbookEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "user-id")
    private UserProfileEntity user;

    @Column(length = 100)
    private String spellbookName;

    private int level;

    @ManyToOne
    @JoinColumn(name = "class-id")
    private ClassEntity characterClass;

    @ManyToMany
    @JoinTable(
            name = "spellbook_spell",
            joinColumns = @JoinColumn(name= "spellbook-id"),
            inverseJoinColumns = @JoinColumn(name = "spell-id")
    )
    private List<SpellEntity> spells;

    @OneToMany(mappedBy = "spellbook")
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

    public List<SpellEntity> getSpells() {
        return spells;
    }

    public void setSpells(List<SpellEntity> spells) {
        this.spells = spells;
    }

    public List<ShareEntity> getShares() {
        return shares;
    }

    public void setShares(List<ShareEntity> shares) {
        this.shares = shares;
    }
}

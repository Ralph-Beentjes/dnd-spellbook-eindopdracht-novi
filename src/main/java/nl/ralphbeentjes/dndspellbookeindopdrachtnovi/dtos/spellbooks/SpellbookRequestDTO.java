package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spellbooks;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.ClassEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.ShareEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.UserProfileEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpellbookRequestDTO {
    private UserProfileEntity userProfile;
    private String spellbookName;
    private int level;
    private ClassEntity classEntity;
    private Set<SpellEntity> spells = new HashSet<>();
    private List<ShareEntity> shares = new ArrayList<>();

    public UserProfileEntity getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfileEntity userProfile) {
        this.userProfile = userProfile;
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

    public ClassEntity getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(ClassEntity classEntity) {
        this.classEntity = classEntity;
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

package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spellbooks;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.ShareEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.UserProfileEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpellbookRequestDTO {
    private Long userProfileId;
    private String spellbookName;
    private int level;
    private Long classId;
    private Set<Long> spellIds;
    private List<Long> shareIds;

    public Long getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(Long userProfileId) {
        this.userProfileId = userProfileId;
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

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Set<Long> getSpellIds() {
        return spellIds;
    }

    public void setSpellIds(Set<Long> spellIds) {
        this.spellIds = spellIds;
    }

    public List<Long> getShareIds() {
        return shareIds;
    }

    public void setShareIds(List<Long> shareIds) {
        this.shareIds = shareIds;
    }
}

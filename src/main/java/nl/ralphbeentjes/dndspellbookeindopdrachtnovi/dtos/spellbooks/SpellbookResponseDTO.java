package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spellbooks;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.classes.ClassResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.shares.ShareResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spells.SpellResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.userprofiles.UserProfileResponseDTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpellbookResponseDTO {
    private Long id;
    private UserProfileResponseDTO userProfile;
    private String spellbookName;
    private int level;
    private ClassResponseDTO characterClass;
    private Set<SpellResponseDTO> spells;
    private List<ShareResponseDTO> shares;

    public Long getId() {
        return id;
    }

    public UserProfileResponseDTO getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfileResponseDTO userProfile) {
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

    public ClassResponseDTO getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(ClassResponseDTO characterClass) {
        this.characterClass = characterClass;
    }

    public Set<SpellResponseDTO> getSpells() {
        return spells;
    }

    public void setSpells(Set<SpellResponseDTO> spells) {
        this.spells = spells;
    }

    public List<ShareResponseDTO> getShares() {
        return shares;
    }

    public void setShares(List<ShareResponseDTO> shares) {
        this.shares = shares;
    }
}

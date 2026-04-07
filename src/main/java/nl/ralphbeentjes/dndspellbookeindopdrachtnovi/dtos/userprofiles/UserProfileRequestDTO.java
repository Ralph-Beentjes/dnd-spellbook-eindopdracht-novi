package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.userprofiles;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellbookEntity;

import java.util.Set;

public class UserProfileRequestDTO {
    private String username;

    private Set<Long> spellbookIds;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Long> getSpellbookIds() {
        return spellbookIds;
    }

    public void setSpellbookIds(Set<Long> spellbookIds) {
        this.spellbookIds = spellbookIds;
    }
}

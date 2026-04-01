package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.userprofiles;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellbookEntity;

import java.util.Set;

public class UserProfileRequestDTO {
    private String username;
    private Set<SpellbookEntity> spellbooks;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<SpellbookEntity> getSpellbooks() {
        return spellbooks;
    }

    public void setSpellbooks(Set<SpellbookEntity> spellbooks) {
        this.spellbooks = spellbooks;
    }
}

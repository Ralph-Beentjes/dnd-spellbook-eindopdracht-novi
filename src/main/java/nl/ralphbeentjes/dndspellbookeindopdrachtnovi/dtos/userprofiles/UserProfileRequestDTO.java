package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.userprofiles;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellbookEntity;

import java.util.Set;

public class UserProfileRequestDTO {
    private Set<SpellbookEntity> spellbooks;

    public Set<SpellbookEntity> getSpellbooks() {
        return spellbooks;
    }

    public void setSpellbooks(Set<SpellbookEntity> spellbooks) {
        this.spellbooks = spellbooks;
    }
}

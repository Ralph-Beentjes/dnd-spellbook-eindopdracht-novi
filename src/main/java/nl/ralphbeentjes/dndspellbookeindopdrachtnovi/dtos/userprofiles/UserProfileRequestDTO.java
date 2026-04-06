package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.userprofiles;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellbookEntity;

import java.util.Set;

public class UserProfileRequestDTO {
    private Set<Long> spellbookIds;

    public Set<Long> getSpellbookIds() {
        return spellbookIds;
    }

    public void setSpellbookIds(Set<Long> spellbookIds) {
        this.spellbookIds = spellbookIds;
    }
}

package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spellbooks;

import java.util.List;

public class AddSpellsRequestDTO {
    private List<Long> spellIds;
    private Long userProfileId;

    public List<Long> getSpellIds() {
        return spellIds;
    }

    public void setSpellIds(List<Long> spellIds) {
        this.spellIds = spellIds;
    }

    public Long getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(Long userProfileId) {
        this.userProfileId = userProfileId;
    }
}
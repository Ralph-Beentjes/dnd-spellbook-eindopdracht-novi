package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.userprofiles;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spellbooks.SpellbookResponseDTO;

import java.util.Set;

public class UserProfileResponseDTO {
    private Long id;
    private String username;
    private Set<SpellbookResponseDTO> spellbooks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<SpellbookResponseDTO> getSpellbooks() {
        return spellbooks;
    }

    public void setSpellbooks(Set<SpellbookResponseDTO> spellbooks) {
        this.spellbooks = spellbooks;
    }
}

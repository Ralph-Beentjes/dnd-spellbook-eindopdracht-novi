package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "user_profiles")
public class UserProfileEntity extends BaseEntity {
    private String username;

    @OneToMany(mappedBy = "user_profile", fetch = FetchType.LAZY)
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

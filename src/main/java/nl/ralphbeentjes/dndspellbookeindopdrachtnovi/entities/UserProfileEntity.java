package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "user_profiles")
public class UserProfileEntity extends BaseEntity {
    @Column(name = "keycloak_id", unique = true, nullable = false)
    private String keycloakId;

    private String username;

    @OneToMany(mappedBy = "user_profile", fetch = FetchType.LAZY)
    private Set<SpellbookEntity> spellbooks;

    public String getKeycloakId() {
        return keycloakId;
    }

    public void setKeycloakId(String keycloakId) {
        this.keycloakId = keycloakId;
    }

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

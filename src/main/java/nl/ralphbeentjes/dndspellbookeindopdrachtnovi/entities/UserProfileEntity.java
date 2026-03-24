package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities;

import jakarta.persistence.*;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.enums.Role;

import java.util.List;

@Entity
@Table(name = "user_profiles")
public class UserProfileEntity extends BaseEntity {
    @Column(length = 100)
    private String username;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user_profile", fetch = FetchType.LAZY)
    private List<SpellbookEntity> spellbooks;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<SpellbookEntity> getSpellbooks() {
        return spellbooks;
    }

    public void setSpellbooks(List<SpellbookEntity> spellbooks) {
        this.spellbooks = spellbooks;
    }
}

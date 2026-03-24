package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "shares")
public class ShareEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "spellbook-id")
    private SpellbookEntity spellbook;

    @Column(nullable = false)
    private String createdBy;

    private Date createdOn;

    public SpellbookEntity getSpellbook() {
        return spellbook;
    }

    public void setSpellbook(SpellbookEntity spellbook) {
        this.spellbook = spellbook;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}

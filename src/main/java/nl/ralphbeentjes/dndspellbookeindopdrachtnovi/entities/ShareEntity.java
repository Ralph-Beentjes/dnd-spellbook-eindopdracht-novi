package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "shares")
public class ShareEntity extends BaseEntity {
    private SpellbookEntity spellbook;
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

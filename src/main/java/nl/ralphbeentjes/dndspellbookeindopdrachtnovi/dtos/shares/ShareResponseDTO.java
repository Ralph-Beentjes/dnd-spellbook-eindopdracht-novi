package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.shares;

import java.time.LocalDateTime;

public class ShareResponseDTO {
    private Long id;
    private Long spellbookId;
    private String createdBy;
    private LocalDateTime createdOn;

    public Long getId() {
        return id;
    }

    public Long getSpellbookId() {
        return spellbookId;
    }

    public void setSpellbookId(Long spellbookId) {
        this.spellbookId = spellbookId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }
}

package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.shares;

import java.time.LocalDateTime;

public class ShareResponseDTO {
    private Long id;
    private Long spellbookId;
    private String shareToken;
    private String createdBy;
    private LocalDateTime createdOn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public Long getSpellbookId() {
        return spellbookId;
    }

    public void setSpellbookId(Long spellbookId) {
        this.spellbookId = spellbookId;
    }

    public String getShareToken() { return shareToken; }

    public void setShareToken(String shareToken) { this.shareToken = shareToken; }

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

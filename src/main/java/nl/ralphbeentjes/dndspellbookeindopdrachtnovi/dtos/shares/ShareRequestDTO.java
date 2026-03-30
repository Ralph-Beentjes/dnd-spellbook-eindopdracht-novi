package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.shares;

public class ShareRequestDTO {
    private Long spellbookId;
    private String createdBy;

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
}

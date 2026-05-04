package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "spellbooks")
public class SpellbookEntity extends BaseEntity {
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserProfileEntity userProfile;

    @Column(length = 100)
    private String spellbookName;

    private int level;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "class_id", nullable = false)
    private ClassEntity characterClass;

    @ManyToMany (fetch = FetchType.LAZY)
    @JoinTable(
            name = "spellbook_spell",
            joinColumns = @JoinColumn(name= "spellbook_id"),
            inverseJoinColumns = @JoinColumn(name = "spell_id")
    )
    private Set<SpellEntity> spells = new HashSet<>();

    @OneToOne(mappedBy = "spellbook", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ShareEntity share;

    @Column(name = "image", columnDefinition = "BYTEA")
    private byte[] image;

    @Column(name = "image_file_name")
    private String imageFileName;

    @Column(name = "image_content_type")
    private String imageContentType;

    public UserProfileEntity getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfileEntity userProfile) {
        this.userProfile = userProfile;
    }

    public String getSpellbookName() {
        return spellbookName;
    }

    public void setSpellbookName(String spellbookName) {
        this.spellbookName = spellbookName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public ClassEntity getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(ClassEntity characterClass) {
        this.characterClass = characterClass;
    }

    public Set<SpellEntity> getSpells() {
        return spells;
    }

    public void setSpells(Set<SpellEntity> spells) {
        this.spells = spells;
    }

    public ShareEntity getShare() {
        return share;
    }

    public void setShare(ShareEntity share) {
        this.share = share;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }
}

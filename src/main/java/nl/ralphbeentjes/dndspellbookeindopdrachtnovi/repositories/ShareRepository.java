package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.repositories;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.ShareEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public interface ShareRepository extends JpaRepository<ShareEntity, Long> {
    Optional<ShareEntity> findBySpellbookId(Long spellbookId);

    @Query("SELECT s FROM ShareEntity s JOIN FETCH s.spellbook WHERE s.shareToken = :token")
    Optional<ShareEntity> findByShareTokenWithSpellbook(@PathVariable String token);
}

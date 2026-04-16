package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.repositories;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellbookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SpellbookRepository extends JpaRepository<SpellbookEntity, Long> {
    @Query("SELECT s FROM SpellbookEntity s JOIN FETCH s.characterClass WHERE s.id = :id")
    Optional<SpellbookEntity> findByIdWithClass(Long id);
}

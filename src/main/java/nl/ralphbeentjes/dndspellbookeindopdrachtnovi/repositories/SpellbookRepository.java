package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.repositories;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellbookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpellbookRepository extends JpaRepository<SpellbookEntity, Long> {
}

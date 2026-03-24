package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.repositories;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpellRepository extends JpaRepository<SpellEntity, Long> {
}

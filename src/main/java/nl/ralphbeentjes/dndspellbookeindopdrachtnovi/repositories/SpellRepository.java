package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.repositories;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpellRepository extends JpaRepository<SpellEntity, Long> {
    Optional<SpellEntity> findBySpellNameIgnoreCase(String spellName);

    List<SpellEntity> findBySpellNameContaining(String spellName);

    List<SpellEntity> findByLevel(int level);

}

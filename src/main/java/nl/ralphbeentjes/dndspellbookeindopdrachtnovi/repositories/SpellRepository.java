package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.repositories;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpellRepository extends JpaRepository<SpellEntity, Long> {
    List<SpellEntity> findByLevel(int level);

    List<SpellEntity> findByLevelAndCharacterClasses_Id(int level, Long classId);

}

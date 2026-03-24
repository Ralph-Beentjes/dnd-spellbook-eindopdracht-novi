package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.repositories;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfileEntity, Long> {
}

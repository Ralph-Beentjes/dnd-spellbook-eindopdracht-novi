package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.repositories;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfileEntity, Long> {
    Optional<UserProfileEntity> findByKeycloakId(String keycloakId);
}

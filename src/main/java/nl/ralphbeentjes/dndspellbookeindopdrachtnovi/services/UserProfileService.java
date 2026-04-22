package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.services;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.userprofiles.UserProfileRequestDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.userprofiles.UserProfileResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellbookEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.UserProfileEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.exceptions.RecordNotFoundException;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.mappers.UserProfileMapper;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.repositories.SpellbookRepository;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.repositories.UserProfileRepository;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserProfileService {
    private final UserProfileRepository userProfileRepository;
    private final UserProfileMapper userProfileMapper;
    private final SpellbookRepository spellbookRepository;

    public UserProfileService(UserProfileRepository userProfileRepository, UserProfileMapper userProfileMapper, SpellbookRepository spellbookRepository) {
        this.userProfileRepository = userProfileRepository;
        this.userProfileMapper = userProfileMapper;
        this.spellbookRepository = spellbookRepository;
    }

    public UserProfileEntity resolveCurrentUser(Jwt jwt) {
        String keycloakId = jwt.getSubject();
        String username   = jwt.getClaimAsString("preferred_username");

        return userProfileRepository.findByKeycloakId(keycloakId)
                .orElseGet(() -> {
                    UserProfileEntity newProfile = new UserProfileEntity();
                    newProfile.setKeycloakId(keycloakId);
                    newProfile.setUsername(username);
                    return userProfileRepository.save(newProfile);
                });
    }

    public List<UserProfileResponseDTO> findAllUserProfiles() {
        return userProfileMapper.toResponseDTOList(userProfileRepository.findAll());
    }

    public UserProfileResponseDTO findUserProfileById(Long id) {
        UserProfileEntity userProfileEntity = userProfileRepository.findById(id).orElseThrow(()-> new RecordNotFoundException("User profile with ID " + id + "not found"));
        return userProfileMapper.toResponseDTO(userProfileEntity);
    }

    public UserProfileResponseDTO createUserProfile(UserProfileRequestDTO userProfileRequestDTO) {
        UserProfileEntity userProfileEntity = userProfileMapper.toEntity(userProfileRequestDTO);

        if (userProfileRequestDTO.getSpellbookIds() != null) {
            Set<SpellbookEntity> spellbooks =
                    new HashSet<>(spellbookRepository.findAllById(userProfileRequestDTO.getSpellbookIds()));
            userProfileEntity.setSpellbooks(spellbooks);
        }

        userProfileEntity = userProfileRepository.save(userProfileEntity);
        return userProfileMapper.toResponseDTO(userProfileEntity);
    }

    public UserProfileResponseDTO updateUserProfile(Long id, UserProfileRequestDTO userProfileRequestDTO) {
        UserProfileEntity existingUserProfileEntity = userProfileRepository.findById(id).orElseThrow(()-> new RecordNotFoundException("User profile with ID " + id + "not found"));

        if (userProfileRequestDTO.getSpellbookIds() != null) {
            Set<SpellbookEntity> spellbooks =
                    new HashSet<>(spellbookRepository.findAllById(userProfileRequestDTO.getSpellbookIds()));
            existingUserProfileEntity.setSpellbooks(spellbooks);
        }

        return userProfileMapper.toResponseDTO(userProfileRepository.save(existingUserProfileEntity));
    }

    public void deleteUserProfile(Long id) {
        userProfileRepository.deleteById(id);
    }
}

package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.services;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spellbooks.SpellbookRequestDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spellbooks.SpellbookResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.ClassEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellbookEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.UserProfileEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.mappers.SpellbookMapper;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.repositories.ShareRepository;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.repositories.SpellRepository;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.repositories.SpellbookRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

import static org.apache.tomcat.util.net.openssl.OpenSSLStatus.setName;

@Service
public class SpellbookService {

    private final SpellbookRepository spellbookRepository;
    private final SpellbookMapper spellbookMapper;
    private final SpellRepository spellRepository;
    private final ShareRepository shareRepository;

    public SpellbookService(
            SpellbookRepository spellbookRepository,
            SpellbookMapper spellbookMapper,
            SpellRepository spellRepository,
            ShareRepository shareRepository
    ) {
        this.spellbookRepository = spellbookRepository;
        this.spellbookMapper = spellbookMapper;
        this.spellRepository = spellRepository;
        this.shareRepository = shareRepository;
    }

    public List<SpellbookResponseDTO> findAllSpellbooks() {
        return spellbookMapper.toResponseDTOList(spellbookRepository.findAll());
    }

    public SpellbookResponseDTO findSpellbookById(Long id) {
        SpellbookEntity spellbookEntity = spellbookRepository.findById(id).orElseThrow(() -> new RuntimeException("Spellbook not found"));
        return spellbookMapper.toResponseDTO(spellbookEntity);
    }

    public SpellbookResponseDTO createSpellbook(SpellbookRequestDTO spellbookRequestDTO) {
        SpellbookEntity entity = spellbookMapper.toEntity(spellbookRequestDTO);

        if (spellbookRequestDTO.getUserProfileId() != null) {
            UserProfileEntity user = new UserProfileEntity();
            user.setId(spellbookRequestDTO.getUserProfileId());
            entity.setUserProfile(user);
        }

        if (spellbookRequestDTO.getClassId() != null) {
            ClassEntity classEntity = new ClassEntity();
            classEntity.setId(spellbookRequestDTO.getClassId());
            entity.setCharacterClass(classEntity);
        }

        if (spellbookRequestDTO.getSpellIds() != null) {
            entity.setSpells(new HashSet<>(spellRepository.findAllById(spellbookRequestDTO.getSpellIds())));
        }

        if (spellbookRequestDTO.getShareIds() != null) {
            entity.setShares(shareRepository.findAllById(spellbookRequestDTO.getShareIds()));
        }

        entity = spellbookRepository.save(entity);
        return spellbookMapper.toResponseDTO(entity);
    }

    public SpellbookResponseDTO updateSpellbook(Long id, SpellbookRequestDTO spellbookRequestDTO) {
        SpellbookEntity entity = spellbookRepository.findById(id).orElseThrow(() -> new RuntimeException("Spellbook not found"));
        entity.setSpellbookName(spellbookRequestDTO.getSpellbookName());
        entity.setLevel(spellbookRequestDTO.getLevel());

        if (spellbookRequestDTO.getClassId() != null) {
            ClassEntity classEntity = new ClassEntity();
            classEntity.setId(spellbookRequestDTO.getClassId());
            entity.setCharacterClass(classEntity);
        }

        if (spellbookRequestDTO.getSpellIds() != null) {
            entity.setSpells(new HashSet<>(spellRepository.findAllById(spellbookRequestDTO.getSpellIds())));
        }

        if (spellbookRequestDTO.getShareIds() != null) {
            entity.setShares(shareRepository.findAllById(spellbookRequestDTO.getShareIds()));
        }

        entity = spellbookRepository.save(entity);
        return spellbookMapper.toResponseDTO(entity);
    }

    public void deleteSpellbook(Long id) {
        spellbookRepository.deleteById(id);
    }

}

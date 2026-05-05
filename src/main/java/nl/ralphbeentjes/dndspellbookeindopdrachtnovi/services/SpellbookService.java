package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.services;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spellbooks.AddSpellsRequestDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spellbooks.SpellbookRequestDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spellbooks.SpellbookResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.*;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.exceptions.RecordNotFoundException;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.mappers.SpellbookMapper;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.repositories.ClassRepository;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.repositories.ShareRepository;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.repositories.SpellRepository;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.repositories.SpellbookRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SpellbookService {

    private final SpellbookRepository spellbookRepository;
    private final SpellbookMapper spellbookMapper;
    private final SpellRepository spellRepository;
    private final ShareRepository shareRepository;
    private final ClassRepository classRepository;

    public SpellbookService(
            SpellbookRepository spellbookRepository,
            SpellbookMapper spellbookMapper,
            SpellRepository spellRepository,
            ShareRepository shareRepository,
            ClassRepository classRepository
    ) {
        this.spellbookRepository = spellbookRepository;
        this.spellbookMapper = spellbookMapper;
        this.spellRepository = spellRepository;
        this.shareRepository = shareRepository;
        this.classRepository = classRepository;
    }

    public List<SpellbookResponseDTO> findAllSpellbooks() {
        return spellbookMapper.toResponseDTOList(spellbookRepository.findAll());
    }

    public SpellbookResponseDTO findSpellbookById(Long id) {
        SpellbookEntity entity = spellbookRepository.findByIdWithClass(id).orElseThrow(() -> new RecordNotFoundException("Spellbook with ID " + id + "not found"));
        return spellbookMapper.toResponseDTO(entity);
    }

    public SpellbookResponseDTO createSpellbook(SpellbookRequestDTO spellbookRequestDTO) {
        SpellbookEntity entity = spellbookMapper.toEntity(spellbookRequestDTO);

        if (spellbookRequestDTO.getUserProfileId() != null) {
            UserProfileEntity user = new UserProfileEntity();
            user.setId(spellbookRequestDTO.getUserProfileId());
            entity.setUserProfile(user);
        }

        if (spellbookRequestDTO.getClassId() != null) {
            ClassEntity classEntity = classRepository.findById(spellbookRequestDTO.getClassId()).orElseThrow(() -> new RecordNotFoundException("Class with ID " + spellbookRequestDTO.getClassId() + " not found"));
            entity.setCharacterClass(classEntity);
        }

        if (spellbookRequestDTO.getSpellIds() != null) {
            entity.setSpells(new HashSet<>(spellRepository.findAllById(spellbookRequestDTO.getSpellIds())));
        }

        if (spellbookRequestDTO.getShareId() != null) {
            ShareEntity share = shareRepository.findById(spellbookRequestDTO.getShareId()).orElseThrow(() -> new RecordNotFoundException("Share with ID " + spellbookRequestDTO.getShareId() + " not found"));
            entity.setShare(share);
        }

        entity = spellbookRepository.save(entity);
        return spellbookMapper.toResponseDTO(entity);
    }

    public SpellbookResponseDTO updateSpellbook(Long id, SpellbookRequestDTO spellbookRequestDTO) {
        SpellbookEntity entity = spellbookRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Spellbook with ID " + id + "not found"));
        entity.setSpellbookName(spellbookRequestDTO.getSpellbookName());
        entity.setLevel(spellbookRequestDTO.getLevel());

        if (spellbookRequestDTO.getClassId() != null) {
            ClassEntity classEntity = classRepository.findById(spellbookRequestDTO.getClassId()).orElseThrow(() -> new RecordNotFoundException("Class with ID " + spellbookRequestDTO.getClassId() + " not found"));
            entity.setCharacterClass(classEntity);
        }

        if (spellbookRequestDTO.getSpellIds() != null) {
            Set<SpellEntity> newSpells = new HashSet<>(spellRepository.findAllById(spellbookRequestDTO.getSpellIds()));
            entity.getSpells().addAll(newSpells);
        }

        if (spellbookRequestDTO.getShareId() != null) {
            ShareEntity share = shareRepository.findById(spellbookRequestDTO.getShareId()).orElseThrow(() -> new RecordNotFoundException("Share with ID " + spellbookRequestDTO.getShareId() + " not found"));
            entity.setShare(share);
        }

        entity = spellbookRepository.save(entity);
        return spellbookMapper.toResponseDTO(entity);
    }

    public SpellbookResponseDTO addSpellsToSpellbook(Long id, AddSpellsRequestDTO request) {
        SpellbookEntity entity = spellbookRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Spellbook with ID " + id + "not found"));

        if (request.getSpellIds() != null && !request.getSpellIds().isEmpty()) {
            Set<SpellEntity> newSpells = new HashSet<>(spellRepository.findAllById(request.getSpellIds()));
            entity.getSpells().addAll(newSpells);
        }

        entity = spellbookRepository.save(entity);
        return spellbookMapper.toResponseDTO(entity);
    }

    public SpellbookResponseDTO removeSpellFromSpellbook(Long spellbookId, Long spellId) {
        SpellbookEntity entity = spellbookRepository.findById(spellbookId).orElseThrow(() -> new RecordNotFoundException("Spellbook with ID " + spellbookId + "not found"));

        entity.getSpells().removeIf(spell -> spell.getId().equals(spellId));

        entity = spellbookRepository.save(entity);
        return spellbookMapper.toResponseDTO(entity);
    }

    public SpellbookResponseDTO levelUpSpellbook(Long id) {
        SpellbookEntity entity = spellbookRepository.findByIdWithClass(id).orElseThrow(() -> new RecordNotFoundException("Spellbook with ID " + id + "not found"));

        entity.setLevel(entity.getLevel() + 1);
        entity = spellbookRepository.save(entity);

        return spellbookMapper.toResponseDTO(entity);
    }

    public void deleteSpellbook(Long id) {
        spellbookRepository.deleteById(id);
    }

    public void uploadImage(Long id, MultipartFile file) throws IOException {
        SpellbookEntity entity = spellbookRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Spellbook with ID " + id + "not found"));

        entity.setImage(file.getBytes());
        entity.setImageFileName(file.getOriginalFilename());
        entity.setImageContentType(file.getContentType());

        spellbookRepository.save(entity);
    }

    public ResponseEntity<byte[]> downloadImage(Long id) {
        SpellbookEntity entity = spellbookRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Spellbook with ID " + id + "not found"));

        if (entity.getImage() == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + entity.getImageFileName() + "\"")
                .contentType(MediaType.parseMediaType(entity.getImageContentType()))
                .body(entity.getImage());
    }

}

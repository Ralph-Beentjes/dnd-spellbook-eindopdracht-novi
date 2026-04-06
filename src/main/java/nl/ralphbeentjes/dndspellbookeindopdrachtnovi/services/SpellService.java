package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.services;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spells.SpellRequestDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spells.SpellResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.ClassEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellbookEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.mappers.SpellMapper;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.repositories.ClassRepository;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.repositories.SpellRepository;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.repositories.SpellbookRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SpellService {
    private final SpellRepository spellRepository;
    private final SpellMapper spellMapper;
    private final ClassRepository classRepository;
    private final SpellbookRepository spellbookRepository;

    public SpellService(SpellRepository spellRepository, SpellMapper spellMapper, ClassRepository classRepository, SpellbookRepository spellbookRepository) {
        this.spellRepository = spellRepository;
        this.spellMapper = spellMapper;
        this.classRepository = classRepository;
        this.spellbookRepository = spellbookRepository;
    }

    public List<SpellResponseDTO> findAllSpells() {
        return spellMapper.toResponseDTOList(spellRepository.findAll());
    }

    public List<SpellResponseDTO> findAllSpellsWithContain(String spellName) {
        List<SpellEntity> spellEntities = spellRepository.findBySpellNameContaining(spellName);
        return spellMapper.toResponseDTOList(spellEntities);
    }

    public SpellResponseDTO findSpellById(Long id) {
        SpellEntity spellEntity = spellRepository.findById(id).orElseThrow(()-> new RuntimeException("Spell not found"));
        return spellMapper.toResponseDTO(spellEntity);
    }

    public SpellResponseDTO findSpellByName(String spellName) {
        SpellEntity spellEntity = spellRepository.findBySpellNameIgnoreCase(spellName).orElseThrow(()-> new RuntimeException("Spell not found"));
        return spellMapper.toResponseDTO(spellEntity);
    }

    public SpellResponseDTO createSpell(SpellRequestDTO spellRequestDTO) {
        SpellEntity spellEntity = spellMapper.toEntity(spellRequestDTO);

        if (spellRequestDTO.getClassIds() != null) {
            Set<ClassEntity> classes =
                    new HashSet<>(classRepository.findAllById(spellRequestDTO.getClassIds()));
            spellEntity.setClasses(classes);
        }

        spellEntity = spellRepository.save(spellEntity);
        return spellMapper.toResponseDTO(spellEntity);
    }

    public SpellResponseDTO updateSpell(Long id, SpellRequestDTO spellRequestDTO) {
        SpellEntity existingSpellEntity = spellRepository.findById(id).orElseThrow(()-> new RuntimeException("Spell not found"));

        existingSpellEntity.setSpellName(spellRequestDTO.getSpellName());
        existingSpellEntity.setLevel(spellRequestDTO.getLevel());
        existingSpellEntity.setCastingTime(spellRequestDTO.getCastingTime());
        existingSpellEntity.setRange(spellRequestDTO.getRange());
        existingSpellEntity.setComponents(spellRequestDTO.getComponents());
        existingSpellEntity.setDuration(spellRequestDTO.getDuration());
        existingSpellEntity.setConcentration(spellRequestDTO.isConcentration());
        existingSpellEntity.setDescription(spellRequestDTO.getDescription());

        if (spellRequestDTO.getClassIds() != null) {
            Set<ClassEntity> classes =
                    new HashSet<>(classRepository.findAllById(spellRequestDTO.getClassIds()));
            existingSpellEntity.setClasses(classes);
        }

        if (spellRequestDTO.getSpellbookIds() != null) {
            Set<SpellbookEntity> spellbooks =
                    new HashSet<>(spellbookRepository.findAllById(spellRequestDTO.getSpellbookIds()));
            existingSpellEntity.setSpellbooks(spellbooks);
        }

        return spellMapper.toResponseDTO(spellRepository.save(existingSpellEntity));
    }

    public void deleteSpell(Long id) {
        spellRepository.deleteById(id);
    }
}

package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.services;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spellbooks.SpellbookRequestDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spellbooks.SpellbookResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellbookEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.mappers.SpellbookMapper;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.repositories.SpellbookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.apache.tomcat.util.net.openssl.OpenSSLStatus.setName;

@Service
public class SpellbookService {
    private final SpellbookRepository spellbookRepository;
    private final SpellbookMapper spellbookMapper;

    public SpellbookService(SpellbookRepository spellbookRepository, SpellbookMapper spellbookMapper) {
        this.spellbookRepository = spellbookRepository;
        this.spellbookMapper = spellbookMapper;
    }

    public List<SpellbookResponseDTO> findAllSpellbooks() {
        return spellbookMapper.toResponseDTO(spellbookRepository.findAll());
    }

    public SpellbookResponseDTO findSpellbookById(Long id) {
        SpellbookEntity spellbookEntity = spellbookRepository.findById(id).orElseThrow(() -> new RuntimeException("Spellbook not found"));
        return spellbookMapper.toResponseDTO(spellbookEntity);
    }

    public SpellbookResponseDTO createSpellbook(SpellbookRequestDTO spellbookRequestDTO) {
        SpellbookEntity spellbookEntity = spellbookMapper.toEntity(spellbookRequestDTO);
        spellbookEntity = spellbookRepository.save(spellbookEntity);
        return spellbookMapper.toResponseDTO(spellbookEntity);
    }

    public SpellbookResponseDTO updateSpellbook(Long id, SpellbookRequestDTO spellbookRequestDTO) {
        SpellbookEntity existingSpellbookEntity = spellbookRepository.findById(id).orElseThrow(() -> new RuntimeException("Spellbook not found"));

        existingSpellbookEntity.setSpellbookName(spellbookRequestDTO.getSpellbookName());
        existingSpellbookEntity.setLevel(spellbookRequestDTO.getLevel());
        existingSpellbookEntity.setSpells(spellbookRequestDTO.getSpells());

        existingSpellbookEntity = spellbookRepository.save(existingSpellbookEntity);
        return spellbookMapper.toResponseDTO(existingSpellbookEntity);
    }

    public void deleteSpellbook(Long id) {
        spellbookRepository.deleteById(id);
    }

}

package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.services;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.shares.ShareRequestDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.shares.ShareResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.ShareEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellbookEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.mappers.ShareMapper;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.repositories.ShareRepository;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.repositories.SpellbookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShareService {
    private final ShareRepository shareRepository;
    private final ShareMapper shareMapper;
    private final SpellbookRepository spellbookRepository;

    public ShareService(ShareRepository shareRepository, ShareMapper shareMapper, SpellbookRepository spellbookRepository) {
        this.shareRepository = shareRepository;
        this.shareMapper = shareMapper;
        this.spellbookRepository = spellbookRepository;
    }

    public List<ShareResponseDTO> findAllShares() {
        return shareMapper.toResponseDTOList(shareRepository.findAll());
    }

    public ShareResponseDTO findShareById(Long id) {
        ShareEntity shareEntity = shareRepository.findById(id).orElseThrow(()-> new RuntimeException("Share not found"));
        return shareMapper.toResponseDTO(shareEntity);
    }

    public ShareResponseDTO createShare(ShareRequestDTO shareRequestDTO) {
        ShareEntity shareEntity = shareMapper.toEntity(shareRequestDTO);

        SpellbookEntity spellbook = spellbookRepository.findById(shareRequestDTO.getSpellbookId())
                .orElseThrow(() -> new RuntimeException("Spellbook not found"));

        shareEntity.setSpellbook(spellbook);

        shareRepository.save(shareEntity);
        return shareMapper.toResponseDTO(shareEntity);
    }

    public ShareResponseDTO updateShare(ShareRequestDTO shareRequestDTO) {
        ShareEntity shareEntity = shareMapper.toEntity(shareRequestDTO);

        SpellbookEntity spellbook = spellbookRepository.findById(shareRequestDTO.getSpellbookId())
                .orElseThrow(() -> new RuntimeException("Spellbook not found"));

        shareEntity.setSpellbook(spellbook);

        shareRepository.save(shareEntity);
        return shareMapper.toResponseDTO(shareEntity);
    }

    public void deleteShare(Long id) {
        shareRepository.deleteById(id);
    }
}

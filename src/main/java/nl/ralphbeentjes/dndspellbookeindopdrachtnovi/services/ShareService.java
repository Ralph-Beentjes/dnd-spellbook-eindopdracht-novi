package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.services;

import jakarta.transaction.Transactional;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.shares.ShareRequestDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.shares.ShareResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spellbooks.SpellbookResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.ShareEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellbookEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.mappers.ShareMapper;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.mappers.SpellbookMapper;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.repositories.ShareRepository;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.repositories.SpellbookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ShareService {
    private final ShareRepository shareRepository;
    private final ShareMapper shareMapper;
    private final SpellbookRepository spellbookRepository;
    private final SpellbookMapper spellbookMapper;

    public ShareService(ShareRepository shareRepository, ShareMapper shareMapper, SpellbookRepository spellbookRepository, SpellbookMapper spellbookMapper) {
        this.shareRepository = shareRepository;
        this.shareMapper = shareMapper;
        this.spellbookRepository = spellbookRepository;
        this.spellbookMapper = spellbookMapper;
    }

    public List<ShareResponseDTO> findAllShares() {
        return shareMapper.toResponseDTOList(shareRepository.findAll());
    }

    public String getOrCreateShareToken(Long spellbookId, String username) {
        return shareRepository.findBySpellbookId(spellbookId)
                .map(ShareEntity::getShareToken)
                .orElseGet(() -> {
                    SpellbookEntity spellbook = spellbookRepository.findById(spellbookId)
                            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Spellbook with ID" + spellbookId + " not found"));

                    ShareEntity share = new ShareEntity();
                    share.setSpellbook(spellbook);
                    share.setShareToken(UUID.randomUUID().toString());
                    share.setCreatedBy(username);
                    share.setCreatedOn(new Date());
                    shareRepository.save(share);
                    return share.getShareToken();
                });
    }

    @Transactional
    public SpellbookResponseDTO getSpellbookByToken(String token) {
        ShareEntity share = shareRepository.findByShareTokenWithSpellbook(token)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Share link not found"));

        return spellbookMapper.toResponseDTO(share.getSpellbook());
    }

    public ShareResponseDTO createShare(ShareRequestDTO shareRequestDTO) {
        ShareEntity shareEntity = shareMapper.toEntity(shareRequestDTO);

        SpellbookEntity spellbook = spellbookRepository.findById(shareRequestDTO.getSpellbookId())
                .orElseThrow(() -> new RuntimeException("Spellbook not found"));

        shareEntity.setSpellbook(spellbook);

        shareRepository.save(shareEntity);
        return shareMapper.toResponseDTO(shareEntity);
    }

    public ShareResponseDTO updateShare(Long id, ShareRequestDTO shareRequestDTO) {
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

package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.controllers;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.shares.ShareRequestDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.shares.ShareResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spellbooks.SpellbookResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.services.ShareService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shares")
public class ShareController {
    private final ShareService shareService;

    public ShareController(ShareService shareService) {
        this.shareService = shareService;
    }

    @GetMapping
    public ResponseEntity<List<ShareResponseDTO>> getAllShares() {
        List<ShareResponseDTO> shares = shareService.findAllShares();
        return new ResponseEntity<>(shares, HttpStatus.OK);
    }

    @GetMapping("/{token}")
    public ResponseEntity<SpellbookResponseDTO> getSharedSpellbook(@PathVariable String token) {
        SpellbookResponseDTO spellbook = shareService.getSpellbookByToken(token);
        return ResponseEntity.ok(spellbook);
    }

    @PostMapping("/spellbooks/{spellbookId}")
    public ResponseEntity<Map<String, String>> createShare(
            @PathVariable Long spellbookId,
            @AuthenticationPrincipal Jwt jwt) {

        String username = jwt.getSubject();
        String token = shareService.getOrCreateShareToken(spellbookId, username);
        return ResponseEntity.ok(Map.of("shareToken", token));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShareResponseDTO> updateShare(@PathVariable Long id, @RequestBody ShareRequestDTO shareRequestDTO) {
        ShareResponseDTO shareResponseDTO = shareService.updateShare(id, shareRequestDTO);
        return new ResponseEntity<>(shareResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ShareResponseDTO> deleteShare(@PathVariable Long id) {
        shareService.deleteShare(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

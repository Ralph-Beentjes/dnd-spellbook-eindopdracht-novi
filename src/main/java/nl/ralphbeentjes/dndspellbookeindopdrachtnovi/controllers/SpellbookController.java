package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.controllers;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spellbooks.AddSpellsRequestDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spellbooks.SpellbookRequestDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spellbooks.SpellbookResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.services.SpellbookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/spellbooks")
public class SpellbookController {
    private final SpellbookService spellbookService;

    public SpellbookController(SpellbookService spellbookService) {
        this.spellbookService = spellbookService;
    }

    @GetMapping
    public ResponseEntity<List<SpellbookResponseDTO>> getAllSpellbooks() {
        List<SpellbookResponseDTO> spellbooks = spellbookService.findAllSpellbooks();
        return new  ResponseEntity<>(spellbooks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpellbookResponseDTO> getSpellbookById(@PathVariable Long id) {
        SpellbookResponseDTO spellbook = spellbookService.findSpellbookById(id);
        return new  ResponseEntity<>(spellbook, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SpellbookResponseDTO> createSpellbook(@RequestBody SpellbookRequestDTO spellbookRequestDTO) {
        SpellbookResponseDTO spellbookResponseDTO = spellbookService.createSpellbook(spellbookRequestDTO);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(spellbookResponseDTO.getId()).toUri();

        return ResponseEntity.created(location).body(spellbookResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpellbookResponseDTO> updateSpellbook(@PathVariable Long id, @RequestBody SpellbookRequestDTO spellbookRequestDTO) {
        SpellbookResponseDTO spellbookResponseDTO = spellbookService.updateSpellbook(id, spellbookRequestDTO);
        return new  ResponseEntity<>(spellbookResponseDTO, HttpStatus.OK);
    }

    @PatchMapping("/{id}/spells")
    public ResponseEntity<SpellbookResponseDTO> addSpellsToSpellbook(@PathVariable Long id, @RequestBody AddSpellsRequestDTO request) {
        SpellbookResponseDTO spellbookResponseDTO = spellbookService.addSpellsToSpellbook(id, request);

        return ResponseEntity.ok(spellbookResponseDTO);
    }

    @PatchMapping("/{id}/level-up")
    public ResponseEntity<SpellbookResponseDTO> levelUpSpellbook(@PathVariable Long id) {
        SpellbookResponseDTO spellbookResponseDTO = spellbookService.levelUpSpellbook(id);
        return ResponseEntity.ok(spellbookResponseDTO);
    }

    @DeleteMapping("/{spellbookId}/spells/{spellId}")
    public ResponseEntity<SpellbookResponseDTO> removeSpell(@PathVariable Long spellbookId, @PathVariable Long spellId) {
        SpellbookResponseDTO spellbookResponseDTO = spellbookService.removeSpellFromSpellbook(spellbookId, spellId);

        return ResponseEntity.ok(spellbookResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SpellbookResponseDTO> deleteSpellbook(@PathVariable Long id) {
        spellbookService.deleteSpellbook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{id}/image")
    public ResponseEntity<Void> uploadImage(
            @PathVariable Long id,
            @RequestParam("file") MultipartFile file) throws IOException {

        spellbookService.uploadImage(id, file);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<byte[]> downloadImage(@PathVariable Long id) {
        return spellbookService.downloadImage(id);
    }
}

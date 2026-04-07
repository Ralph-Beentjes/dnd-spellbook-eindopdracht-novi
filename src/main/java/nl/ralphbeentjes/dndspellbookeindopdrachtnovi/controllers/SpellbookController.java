package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.controllers;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spellbooks.SpellbookRequestDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spellbooks.SpellbookResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.services.SpellbookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<SpellbookResponseDTO> deleteSpellbook(@PathVariable Long id) {
        spellbookService.deleteSpellbook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

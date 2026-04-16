package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.controllers;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spells.SpellRequestDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spells.SpellResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.services.SpellService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/spells")
public class SpellController {
    private final SpellService spellService;

    public SpellController(SpellService spellService) {
        this.spellService = spellService;
    }

    @GetMapping
    public ResponseEntity<List<SpellResponseDTO>> getAllSpells(){
        List<SpellResponseDTO> spells = spellService.findAllSpells();
        return new ResponseEntity<>(spells, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpellResponseDTO> getSpellById(@PathVariable Long id){
        SpellResponseDTO spell = spellService.findSpellById(id);
        return new ResponseEntity<>(spell, HttpStatus.OK);
    }

    @GetMapping("/level/{level}")
    public ResponseEntity<List<SpellResponseDTO>> getSpellsByLevel(@PathVariable int level) {
        List<SpellResponseDTO> spells = spellService.findAllSpellsWithSpellLevel(level);
        return ResponseEntity.ok(spells);
    }

    @PostMapping
    public ResponseEntity<SpellResponseDTO> createSpell(@RequestBody SpellRequestDTO spellRequestDTO){
        SpellResponseDTO spellResponseDTO = spellService.createSpell(spellRequestDTO);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(spellResponseDTO.getId()).toUri();

        return ResponseEntity.created(location).body(spellResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpellResponseDTO> updateSpell(@PathVariable Long id, @RequestBody SpellRequestDTO spellRequestDTO){
        SpellResponseDTO spellResponseDTO = spellService.updateSpell(id, spellRequestDTO);
        return new ResponseEntity<>(spellResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SpellResponseDTO> deleteSpell(@PathVariable Long id){
        spellService.deleteSpell(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

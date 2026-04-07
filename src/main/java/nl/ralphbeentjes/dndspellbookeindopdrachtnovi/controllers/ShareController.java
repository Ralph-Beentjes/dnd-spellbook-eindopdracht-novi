package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.controllers;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.shares.ShareRequestDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.shares.ShareResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spells.SpellResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.services.ShareService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<ShareResponseDTO> getShareById(Long id) {
        ShareResponseDTO share = shareService.findShareById(id);
        return new ResponseEntity<>(share, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ShareResponseDTO> createShare(@RequestBody ShareRequestDTO shareRequestDTO) {
        ShareResponseDTO shareResponseDTO = shareService.createShare(shareRequestDTO);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(shareResponseDTO.getId()).toUri();

        return ResponseEntity.created(location).body(shareResponseDTO);
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

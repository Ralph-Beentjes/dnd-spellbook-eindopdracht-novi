package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.controllers;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.classes.ClassRequestDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.classes.ClassResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.services.ClassService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassController {
    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping
    public ResponseEntity<List<ClassResponseDTO>> getAllClasses() {
        List<ClassResponseDTO> classes = classService.findAllClasses();
        return new ResponseEntity<>(classes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassResponseDTO> getClassById(@PathVariable Long id) {
        ClassResponseDTO classResponseDTO = classService.findClassById(id);
        return new ResponseEntity<>(classResponseDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClassResponseDTO> createClass(@RequestBody ClassRequestDTO classRequestDTO) {
        ClassResponseDTO classResponseDTO = classService.createClass(classRequestDTO);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(classResponseDTO.getId()).toUri();

        return ResponseEntity.created(location).body(classResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassResponseDTO> updateClass(@PathVariable Long id, @RequestBody ClassRequestDTO classRequestDTO) {
        ClassResponseDTO classResponseDTO = classService.updateClass(id, classRequestDTO);
        return new ResponseEntity<>(classResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClassResponseDTO> deleteClass(@PathVariable Long id) {
        classService.deleteClass(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

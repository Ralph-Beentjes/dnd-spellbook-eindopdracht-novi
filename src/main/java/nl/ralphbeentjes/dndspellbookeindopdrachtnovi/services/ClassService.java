package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.services;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.classes.ClassRequestDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.classes.ClassResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.ClassEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellbookEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.mappers.ClassMapper;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.repositories.ClassRepository;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.repositories.SpellRepository;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.mappers.ClassMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ClassService {
    private final ClassRepository classRepository;
    private final ClassMapper classMapper;
    private final SpellRepository spellRepository;

    public ClassService(ClassRepository classRepository, ClassMapper classMapper, SpellRepository spellRepository) {
        this.classRepository = classRepository;
        this.classMapper = classMapper;
        this.spellRepository = spellRepository;
    }

    public List<ClassResponseDTO> findAllClasses() {
        return classMapper.toResponseDTOList(classRepository.findAll());
    }

    public ClassResponseDTO findClassById(Long id) {
        ClassEntity classEntity = classRepository.findById(id).orElseThrow(()-> new RuntimeException("Class not found"));
        return classMapper.toResponseDTO(classEntity);
    }

    public ClassResponseDTO createClass(ClassRequestDTO classRequestDTO) {
        ClassEntity classEntity = classMapper.toEntity(classRequestDTO);

        if (classRequestDTO.getSpellIds() != null) {
            Set<SpellEntity> spells =
                    new HashSet<>(spellRepository.findAllById(classRequestDTO.getSpellIds()));
            classEntity.setSpells(spells);
        }

        classEntity = classRepository.save(classEntity);
        return classMapper.toResponseDTO(classEntity);
    }

    public ClassResponseDTO updateClass(Long id, ClassRequestDTO classRequestDTO) {
        ClassEntity classEntity = classRepository.findById(id).orElseThrow(()-> new RuntimeException("Class not found"));

        classEntity.setClassName(classRequestDTO.getClassName());
        classEntity.setDescription(classRequestDTO.getDescription());

        if (classRequestDTO.getSpellIds() != null) {
            Set<SpellEntity> spells =
                    new HashSet<>(spellRepository.findAllById(classRequestDTO.getSpellIds()));
            classEntity.setSpells(spells);
        }

        return classMapper.toResponseDTO(classRepository.save(classEntity));
    }

    public void deleteClass(Long id) {
        classRepository.deleteById(id);
    }
}

package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.services;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.classes.ClassRequestDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.classes.ClassResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.ClassEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.enums.CastingTime;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.exceptions.RecordNotFoundException;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.mappers.ClassMapper;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.repositories.ClassRepository;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.repositories.SpellRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClassServiceTest {

    @InjectMocks
    private ClassService classService;

    @Mock
    private ClassRepository classRepository;

    @Mock
    private ClassMapper classMapper;

    @Mock
    private SpellRepository spellRepository;

    private ClassEntity classEntity1;
    private ClassEntity classEntity2;
    private ClassResponseDTO classResponse1;
    private ClassResponseDTO classResponse2;
    private ClassRequestDTO classRequest;
    private SpellEntity spellEntity;

    @BeforeEach
    void setUp() {
        classEntity1 = new ClassEntity();
        classEntity1.setId(1L);
        classEntity1.setClassName("Wizard");
        classEntity1.setDescription("A scholarly magic-user");
        classEntity1.setSpells(new HashSet<>());

        classEntity2 = new ClassEntity();
        classEntity2.setId(2L);
        classEntity2.setClassName("Druid");
        classEntity2.setDescription("A nature-based spellcaster");
        classEntity2.setSpells(new HashSet<>());

        classResponse1 = new ClassResponseDTO();
        classResponse1.setClassName("Wizard");
        classResponse1.setDescription("A scholarly magic-user");

        classResponse2 = new ClassResponseDTO();
        classResponse2.setClassName("Druid");
        classResponse2.setDescription("A nature-based spellcaster");

        classRequest = new ClassRequestDTO();
        classRequest.setClassName("Wizard");
        classRequest.setDescription("A scholarly magic-user");
        classRequest.setSpellIds(null);

        spellEntity = new SpellEntity();
        spellEntity.setSpellName("Fireball");
        spellEntity.setLevel(3);
        spellEntity.setCastingTime(CastingTime.ACTION);
        spellEntity.setRange(150);
        spellEntity.setComponents("V, S, M");
        spellEntity.setDuration("Instantaneous");
        spellEntity.setConcentration(false);
        spellEntity.setDescription("A bright streak flashes from your pointing finger.");
    }

    @Test
    void findAllClasses_shouldReturnListOfClassResponseDTOs() {
        // Arrange
        List<ClassEntity> entities = List.of(classEntity1, classEntity2);
        List<ClassResponseDTO> responses = List.of(classResponse1, classResponse2);

        when(classRepository.findAll()).thenReturn(entities);
        when(classMapper.toResponseDTOList(entities)).thenReturn(responses);

        // Act
        List<ClassResponseDTO> result = classService.findAllClasses();

        // Assert
        assertEquals(2, result.size());
        assertEquals(classResponse1, result.get(0));
        assertEquals(classResponse2, result.get(1));
        verify(classRepository, times(1)).findAll();
        verify(classMapper, times(1)).toResponseDTOList(entities);
    }

    @Test
    void findClassById_shouldReturnClassResponseDTO() {
        // Arrange
        Long id = 1L;

        when(classRepository.findById(id)).thenReturn(Optional.of(classEntity1));
        when(classMapper.toResponseDTO(classEntity1)).thenReturn(classResponse1);

        // Act
        ClassResponseDTO result = classService.findClassById(id);

        // Assert
        assertNotNull(result);
        assertEquals(classResponse1, result);
        verify(classRepository, times(1)).findById(id);
        verify(classMapper, times(1)).toResponseDTO(classEntity1);
    }

    @Test
    void findClassById_shouldThrowRecordNotFoundExceptionWhenClassDoesNotExist() {
        // Arrange
        Long id = 99L;

        when(classRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RecordNotFoundException.class, () -> classService.findClassById(id));
        verify(classRepository, times(1)).findById(id);
        verifyNoInteractions(classMapper);
    }

    @Test
    void createClass_shouldReturnClassResponseDTOWithCreatedClass() {
        // Arrange
        classRequest.setSpellIds(null);

        when(classMapper.toEntity(classRequest)).thenReturn(classEntity1);
        when(classRepository.save(classEntity1)).thenReturn(classEntity1);
        when(classMapper.toResponseDTO(classEntity1)).thenReturn(classResponse1);

        // Act
        ClassResponseDTO result = classService.createClass(classRequest);

        // Assert
        assertNotNull(result);
        assertEquals(classResponse1, result);
        verify(classMapper, times(1)).toEntity(classRequest);
        verify(classRepository, times(1)).save(classEntity1);
        verify(classMapper, times(1)).toResponseDTO(classEntity1);
    }

    @Test
    void createClass_shouldAssignSpellsToClassWhenSpellIdsProvided() {
        // Arrange
        classRequest.setSpellIds(List.of(1L));

        when(classMapper.toEntity(classRequest)).thenReturn(classEntity1);
        when(spellRepository.findAllById(classRequest.getSpellIds())).thenReturn(List.of(spellEntity));
        when(classRepository.save(classEntity1)).thenReturn(classEntity1);
        when(classMapper.toResponseDTO(classEntity1)).thenReturn(classResponse1);

        // Act
        classService.createClass(classRequest);

        // Assert
        verify(spellRepository, times(1)).findAllById(classRequest.getSpellIds());
        assertTrue(classEntity1.getSpells().contains(spellEntity));
        verify(classRepository, times(1)).save(classEntity1);
    }

    @Test
    void updateClass_shouldReturnClassResponseDTOWithUpdatedClass() {
        // Arrange
        Long id = 1L;
        classRequest.setClassName("UpdatedWizard");
        classRequest.setDescription("An updated description");
        classRequest.setSpellIds(null);

        when(classRepository.findById(id)).thenReturn(Optional.of(classEntity1));
        when(classRepository.save(classEntity1)).thenReturn(classEntity1);
        when(classMapper.toResponseDTO(classEntity1)).thenReturn(classResponse1);

        // Act
        ClassResponseDTO result = classService.updateClass(id, classRequest);

        // Assert
        assertNotNull(result);
        assertEquals("UpdatedWizard", classEntity1.getClassName());
        assertEquals("An updated description", classEntity1.getDescription());
        verify(classRepository, times(1)).findById(id);
        verify(classRepository, times(1)).save(classEntity1);
        verify(classMapper, times(1)).toResponseDTO(classEntity1);
    }

    @Test
    void updateClass_shouldAssignSpellsToClassWhenSpellIdsProvided() {
        // Arrange
        Long id = 1L;
        classRequest.setSpellIds(List.of(1L));

        when(classRepository.findById(id)).thenReturn(Optional.of(classEntity1));
        when(spellRepository.findAllById(classRequest.getSpellIds())).thenReturn(List.of(spellEntity));
        when(classRepository.save(classEntity1)).thenReturn(classEntity1);
        when(classMapper.toResponseDTO(classEntity1)).thenReturn(classResponse1);

        // Act
        classService.updateClass(id, classRequest);

        // Assert
        verify(spellRepository, times(1)).findAllById(classRequest.getSpellIds());
        assertTrue(classEntity1.getSpells().contains(spellEntity));
        verify(classRepository, times(1)).save(classEntity1);
    }

    @Test
    void updateClass_shouldThrowRecordNotFoundExceptionWhenClassDoesNotExist() {
        // Arrange
        Long id = 99L;

        when(classRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RecordNotFoundException.class, () -> classService.updateClass(id, classRequest));
        verify(classRepository, times(1)).findById(id);
        verify(classRepository, never()).save(any());
    }

    @Test
    void deleteClass_shouldCallDeleteById() {
        // Arrange
        Long id = 1L;
        doNothing().when(classRepository).deleteById(id);

        // Act
        classService.deleteClass(id);

        // Assert
        verify(classRepository, times(1)).deleteById(id);
    }
}
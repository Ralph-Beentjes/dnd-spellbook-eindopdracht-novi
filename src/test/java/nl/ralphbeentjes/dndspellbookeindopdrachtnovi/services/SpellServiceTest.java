package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.services;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spells.SpellRequestDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spells.SpellResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.ClassEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellbookEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.enums.CastingTime;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.exceptions.RecordNotFoundException;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.mappers.SpellMapper;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.repositories.ClassRepository;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.repositories.SpellRepository;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.repositories.SpellbookRepository;
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
class SpellServiceTest {

    @InjectMocks
    private SpellService spellService;

    @Mock
    private SpellRepository spellRepository;

    @Mock
    private SpellMapper spellMapper;

    @Mock
    private ClassRepository classRepository;

    @Mock
    private SpellbookRepository spellbookRepository;

    private SpellEntity spellEntity1;
    private SpellEntity spellEntity2;
    private SpellResponseDTO spellResponse1;
    private SpellResponseDTO spellResponse2;
    private SpellRequestDTO spellRequest;
    private ClassEntity classEntity;

    @BeforeEach
    void setUp() {
        spellEntity1 = new SpellEntity();
        spellEntity1.setSpellName("Spell001");
        spellEntity1.setLevel(1);
        spellEntity1.setCastingTime(CastingTime.ACTION);
        spellEntity1.setRange(60);
        spellEntity1.setComponents("V, S, M");
        spellEntity1.setDuration("1 minute");
        spellEntity1.setConcentration(false);
        spellEntity1.setDescription("Test description");

        spellEntity2 = new SpellEntity();
        spellEntity2.setSpellName("Spell002");
        spellEntity2.setLevel(2);
        spellEntity2.setCastingTime(CastingTime.BONUS_ACTION);
        spellEntity2.setRange(120);
        spellEntity2.setComponents("V, S, M");
        spellEntity2.setDuration("2 minutes");
        spellEntity2.setConcentration(true);
        spellEntity2.setDescription("Test description 2");

        spellResponse1 = new SpellResponseDTO();
        spellResponse1.setSpellName("Spell1");
        spellResponse1.setLevel(1);
        spellResponse1.setCastingTime(CastingTime.ACTION);
        spellResponse1.setRange(60);
        spellResponse1.setComponents("V, S, M");
        spellResponse1.setDuration("1 minute");
        spellResponse1.setConcentration(false);
        spellResponse1.setDescription("Test description");

        spellResponse2 = new SpellResponseDTO();
        spellResponse2.setSpellName("Spell2");
        spellResponse2.setLevel(2);
        spellResponse2.setCastingTime(CastingTime.BONUS_ACTION);
        spellResponse2.setRange(120);
        spellResponse2.setComponents("V, S, M");
        spellResponse2.setDuration("2 minutes");
        spellResponse2.setConcentration(true);
        spellResponse2.setDescription("Test description 2");

        spellRequest = new SpellRequestDTO();
        spellRequest.setSpellName("NewSpell");
        spellRequest.setLevel(1);
        spellRequest.setCastingTime(CastingTime.ACTION);
        spellRequest.setRange(60);
        spellRequest.setComponents("V, S, M");
        spellRequest.setDuration("1 minute");
        spellRequest.setConcentration(false);
        spellRequest.setDescription("Test description");

        classEntity = new ClassEntity();
        classEntity.setId(5L);
        classEntity.setSpells(new HashSet<>());
    }

    @Test
    void findAllSpells_shouldReturnListOfSpellResponseDTOs() {
        // Arrange
        List<SpellEntity> entities = List.of(spellEntity1, spellEntity2);
        List<SpellResponseDTO> responses = List.of(spellResponse1, spellResponse2);

        when(spellRepository.findAll()).thenReturn(entities);
        when(spellMapper.toResponseDTOList(entities)).thenReturn(responses);

        // Act
        List<SpellResponseDTO> result = spellService.findAllSpells();

        // Assert
        assertEquals(2, result.size());
        assertEquals(spellResponse1, result.get(0));
        assertEquals(spellResponse2, result.get(1));
        verify(spellRepository, times(1)).findAll();
        verify(spellMapper, times(1)).toResponseDTOList(entities);
    }

    @Test
    void findAllSpellsWithSpellLevel_shouldReturnListOfSpellResponseDTOsWithLevel() {
        // Arrange
        int level = 1;
        List<SpellEntity> entities = List.of(spellEntity1);
        List<SpellResponseDTO> responses = List.of(spellResponse1);

        when(spellRepository.findByLevel(level)).thenReturn(entities);
        when(spellMapper.toResponseDTOList(entities)).thenReturn(responses);

        // Act
        List<SpellResponseDTO> result = spellService.findAllSpellsWithSpellLevel(level);

        // Assert
        assertEquals(1, result.size());
        assertTrue(result.stream().allMatch(r -> r.getLevel() == level));
        verify(spellRepository, times(1)).findByLevel(level);
        verify(spellMapper, times(1)).toResponseDTOList(entities);
    }

    @Test
    void findAllSpellsWithLevelAndClass_shouldReturnListOfSpellResponseDTOsWithLevelAndClass() {
        // Arrange
        int level = 1;
        Long classId = 5L;
        List<SpellEntity> entities = List.of(spellEntity1);
        List<SpellResponseDTO> responses = List.of(spellResponse1);

        when(spellRepository.findByLevelAndCharacterClasses_Id(level, classId)).thenReturn(entities);
        when(spellMapper.toResponseDTOList(entities)).thenReturn(responses);

        // Act
        List<SpellResponseDTO> result = spellService.findAllSpellsWithLevelAndClass(level, classId);

        // Assert
        assertEquals(1, result.size());
        assertEquals(spellResponse1, result.get(0));
        verify(spellRepository, times(1)).findByLevelAndCharacterClasses_Id(level, classId);
        verify(spellMapper, times(1)).toResponseDTOList(entities);
    }

    @Test
    void findSpellById_shouldReturnSpellResponseDTO() {
        // Arrange
        Long id = 1L;

        when(spellRepository.findById(id)).thenReturn(Optional.of(spellEntity1));
        when(spellMapper.toResponseDTO(spellEntity1)).thenReturn(spellResponse1);

        // Act
        SpellResponseDTO result = spellService.findSpellById(id);

        // Assert
        assertNotNull(result);
        assertEquals(spellResponse1, result);
        verify(spellRepository, times(1)).findById(id);
        verify(spellMapper, times(1)).toResponseDTO(spellEntity1);
    }

    @Test
    void findSpellById_shouldThrowRecordNotFoundExceptionWhenSpellDoesNotExist() {
        // Arrange
        Long id = 99L;

        when(spellRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RecordNotFoundException.class, () -> spellService.findSpellById(id));
        verify(spellRepository, times(1)).findById(id);
        verifyNoInteractions(spellMapper);
    }

    @Test
    void createSpell_shouldReturnSpellResponseDTOWithCreatedSpell() {
        // Arrange
        spellRequest.setClassIds(null);

        when(spellMapper.toEntity(spellRequest)).thenReturn(spellEntity1);
        when(spellRepository.save(spellEntity1)).thenReturn(spellEntity1);
        when(spellMapper.toResponseDTO(spellEntity1)).thenReturn(spellResponse1);

        // Act
        SpellResponseDTO result = spellService.createSpell(spellRequest);

        // Assert
        assertNotNull(result);
        assertEquals(spellResponse1, result);
        verify(spellMapper, times(1)).toEntity(spellRequest);
        verify(spellRepository, times(2)).save(spellEntity1);
        verify(spellMapper, times(1)).toResponseDTO(spellEntity1);
    }

    @Test
    void createSpell_shouldAssignClassesToSpellWhenClassIdsProvided() {
        // Arrange
        spellRequest.setClassIds(List.of(classEntity.getId()));

        when(spellMapper.toEntity(spellRequest)).thenReturn(spellEntity1);
        when(spellRepository.save(spellEntity1)).thenReturn(spellEntity1);
        when(classRepository.findAllById(spellRequest.getClassIds())).thenReturn(List.of(classEntity));
        when(spellMapper.toResponseDTO(spellEntity1)).thenReturn(spellResponse1);

        // Act
        spellService.createSpell(spellRequest);

        // Assert
        verify(classRepository, times(1)).findAllById(spellRequest.getClassIds());
        verify(classRepository, times(1)).save(classEntity);
        assertTrue(classEntity.getSpells().contains(spellEntity1));
    }

    @Test
    void updateSpell_shouldReturnSpellResponseDTOWithUpdatedSpell() {
        // Arrange
        Long id = 1L;
        spellRequest.setSpellName("UpdatedSpell");
        spellRequest.setLevel(3);
        spellRequest.setClassIds(null);
        spellRequest.setSpellbookIds(null);

        when(spellRepository.findById(id)).thenReturn(Optional.of(spellEntity1));
        when(spellRepository.save(spellEntity1)).thenReturn(spellEntity1);
        when(spellMapper.toResponseDTO(spellEntity1)).thenReturn(spellResponse1);

        // Act
        SpellResponseDTO result = spellService.updateSpell(id, spellRequest);

        // Assert
        assertNotNull(result);
        assertEquals("UpdatedSpell", spellEntity1.getSpellName());
        assertEquals(3, spellEntity1.getLevel());
        verify(spellRepository, times(1)).findById(id);
        verify(spellRepository, times(1)).save(spellEntity1);
        verify(spellMapper, times(1)).toResponseDTO(spellEntity1);
    }

    @Test
    void updateSpell_shouldAssignClassesToSpellWhenClassIdsProvided() {
        // Arrange
        Long id = 1L;
        ClassEntity classEntity = new ClassEntity();
        classEntity.setId(5L);
        spellRequest.setClassIds(List.of(5L));
        spellRequest.setSpellbookIds(null);

        when(spellRepository.findById(id)).thenReturn(Optional.of(spellEntity1));
        when(classRepository.findAllById(spellRequest.getClassIds())).thenReturn(List.of(classEntity));
        when(spellRepository.save(spellEntity1)).thenReturn(spellEntity1);
        when(spellMapper.toResponseDTO(spellEntity1)).thenReturn(spellResponse1);

        // Act
        spellService.updateSpell(id, spellRequest);

        // Assert
        verify(classRepository, times(1)).findAllById(spellRequest.getClassIds());
        assertTrue(spellEntity1.getClasses().contains(classEntity));
    }

    @Test
    void updateSpell_shouldAssignSpellbooksToSpellWhenSpellbookIdsProvided() {
        // Arrange
        Long id = 1L;
        SpellbookEntity spellbookEntity = new SpellbookEntity();
        spellbookEntity.setId(10L);
        spellRequest.setClassIds(null);
        spellRequest.setSpellbookIds(List.of(10L));

        when(spellRepository.findById(id)).thenReturn(Optional.of(spellEntity1));
        when(spellbookRepository.findAllById(spellRequest.getSpellbookIds())).thenReturn(List.of(spellbookEntity));
        when(spellRepository.save(spellEntity1)).thenReturn(spellEntity1);
        when(spellMapper.toResponseDTO(spellEntity1)).thenReturn(spellResponse1);

        // Act
        spellService.updateSpell(id, spellRequest);

        // Assert
        verify(spellbookRepository, times(1)).findAllById(spellRequest.getSpellbookIds());
        assertTrue(spellEntity1.getSpellbooks().contains(spellbookEntity));
    }

    @Test
    void updateSpell_shouldThrowRecordNotFoundExceptionWhenSpellDoesNotExist() {
        // Arrange
        Long id = 99L;

        when(spellRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RecordNotFoundException.class, () -> spellService.updateSpell(id, spellRequest));
        verify(spellRepository, times(1)).findById(id);
        verify(spellRepository, never()).save(any());
    }

    @Test
    void deleteSpell_shouldNotReturnSpellResponseDTO() {
        // Arrange
        Long id = 1L;
        doNothing().when(spellRepository).deleteById(id);

        // Act
        spellService.deleteSpell(id);

        // Assert
        verify(spellRepository, times(1)).deleteById(id);
    }
}
package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.controllers;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spellbooks.SpellbookRequestDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.ClassEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellbookEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.mappers.SpellbookMapper;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.repositories.ClassRepository;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.repositories.SpellbookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import java.net.URI;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.hamcrest.Matchers.is;


@ActiveProfiles("test")
@AutoConfigureMockMvc
@SpringBootTest
class SpellbookControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SpellbookRepository spellbookRepository;

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private ClassEntity wizardClass;

    @BeforeEach
    void setUp() {
        spellbookRepository.deleteAll();
        wizardClass = classRepository.findAll().stream()
                .filter(c -> c.getClassName().equals("Wizard"))
                .findFirst()
                .orElseThrow();
    }

    @Test
    void getAllSpellbooks_shouldReturnListOfSpellbooksWithStatusOk() throws Exception {
        // Arrange
        SpellbookEntity spellbook = new SpellbookEntity();
        spellbook.setSpellbookName("Test Spellbook");
        spellbook.setLevel(1);
        spellbook.setCharacterClass(wizardClass);
        spellbookRepository.save(spellbook);

        // Act & Assert
        mockMvc.perform(get(URI.create("/spellbooks"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()", is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].spellbookName", is("Test Spellbook")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].level", is(1)));
    }

    @Test
    void createSpellbook_shouldReturnCreatedSpellbookWithStatusCreated() throws Exception {
        // Arrange
        SpellbookRequestDTO request = new SpellbookRequestDTO();
        request.setSpellbookName("Gandalf");
        request.setLevel(3);
        request.setClassId(wizardClass.getId());

        // Act & Assert
        mockMvc.perform(post(URI.create("/spellbooks"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.spellbookName", is("My Wizard Spellbook")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.level", is(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.characterClass.className", is("Gandalf")));
    }
}
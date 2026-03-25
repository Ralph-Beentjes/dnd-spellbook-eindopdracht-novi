package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.mappers;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.ClassRequestDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.ClassResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.SpellDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.SpellbookDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.ClassEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellbookEntity;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ClassDTOMapper {

    public static ClassEntity toEntity(ClassRequestDTO dto,
                                       List<SpellbookEntity> spellbooks,
                                       Set<SpellEntity> spells) {
        ClassEntity entity = new ClassEntity();
        entity.setClassName(dto.getClassName());
        entity.setDescription(dto.getDescription());


        entity.setSpellbooks(spellbooks);
        entity.setSpells(spells);

        return entity;
    }

    public static ClassResponseDTO toResponseDTO(ClassEntity entity) {
        ClassResponseDTO dto = new ClassResponseDTO();
        dto.setId(entity.getId());
        dto.setClassName(entity.getClassName());
        dto.setDescription(entity.getDescription());

        if (entity.getSpellbooks() != null) {
            List<SpellbookDTO> spellbookDTOs = entity.getSpellbooks().stream()
                    .map(sb -> {
                        SpellbookDTO sbdto = new SpellbookDTO();
                        sbdto.setId(sb.getId());
                        sbdto.setTitle(sb.getTitle());
                        sbdto.setAuthor(sb.getAuthor());
                        return sbdto;
                    }).collect(Collectors.toList());
            dto.setSpellbooks(spellbookDTOs);
        }

        if (entity.getSpells() != null) {
            Set<SpellDTO> spellDTOs = entity.getSpells().stream()
                    .map(sp -> {
                        SpellDTO sdto = new SpellDTO();
                        sdto.setId(sp.getId());
                        sdto.setName(sp.getName());
                        sdto.setEffect(sp.getEffect());
                        return sdto;
                    }).collect(Collectors.toSet());
            dto.setSpells(spellDTOs);
        }
        return dto;
    }

    public static List<ClassResponseDTO> toResponseDTOList(List<ClassEntity> entities) {
        return entities.stream()
                .map(ClassDTOMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}

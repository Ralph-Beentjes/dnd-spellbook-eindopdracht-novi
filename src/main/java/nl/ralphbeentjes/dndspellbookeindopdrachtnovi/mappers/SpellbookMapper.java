package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.mappers;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spellbooks.SpellbookRequestDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spellbooks.SpellbookResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.ClassEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellbookEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.UserProfileEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SpellbookMapper {

    @Mapping(target = "characterClass", source = "classId")
    @Mapping(target = "userProfile", source = "userProfileId")
    @Mapping(target = "spells", ignore = true)   // handled in service
    @Mapping(target = "shares", ignore = true)   // handled in service
    SpellbookEntity toEntity(SpellbookRequestDTO dto);

    SpellbookResponseDTO toResponseDTO(SpellbookEntity entity);

    List<SpellbookResponseDTO> toResponseDTO(List<SpellbookEntity> entities);

    default ClassEntity map(Long id) {
        if (id == null) return null;
        ClassEntity entity = new ClassEntity();
        entity.setId(id);
        return entity;
    }

    default UserProfileEntity mapUser(Long id) {
        if (id == null) return null;
        UserProfileEntity entity = new UserProfileEntity();
        entity.setId(id);
        return entity;
    }
}

package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.mappers;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spellbooks.SpellbookRequestDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spellbooks.SpellbookResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellbookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {SpellMapper.class, ClassMapper.class})
public interface SpellbookMapper {

    SpellbookMapper INSTANCE = Mappers.getMapper(SpellbookMapper.class);

    @Mapping(target = "classEntity", source = "classEntity")
    SpellbookEntity toEntity(SpellbookRequestDTO spellbookRequestDTO);

    @Mapping(target = "characterClass", source = "classEntity")
    SpellbookResponseDTO toResponseDTO(SpellbookEntity spellbook);

    List<SpellbookResponseDTO> toResponseDTO(List<SpellbookEntity> spellbooks);
}

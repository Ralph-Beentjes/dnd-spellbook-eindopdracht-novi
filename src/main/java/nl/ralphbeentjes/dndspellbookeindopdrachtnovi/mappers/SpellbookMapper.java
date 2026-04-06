package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.mappers;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spellbooks.SpellbookRequestDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spellbooks.SpellbookResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellbookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {ClassMapper.class, UserProfileMapper.class})
public interface SpellbookMapper {

    SpellbookMapper INSTANCE = Mappers.getMapper(SpellbookMapper.class);

    @Mapping(target = "characterClass", ignore = true)
    @Mapping(target = "userProfile", ignore = true)
    @Mapping(target = "spells", ignore = true)
    @Mapping(target = "shares", ignore = true)
    SpellbookEntity toEntity(SpellbookRequestDTO dto);

    SpellbookResponseDTO toResponseDTO(SpellbookEntity entity);

    List<SpellbookResponseDTO> toResponseDTOList(List<SpellbookEntity> entities);
}

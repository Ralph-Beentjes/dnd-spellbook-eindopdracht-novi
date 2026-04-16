package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.mappers;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spells.SpellRequestDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spells.SpellResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SpellbookMapper.class, ClassMapper.class})
public interface SpellMapper {

    @Mapping(target = "spellbooks", ignore = true)
    @Mapping(target = "classes", ignore = true)
    SpellEntity toEntity(SpellRequestDTO dto);

    SpellResponseDTO toResponseDTO(SpellEntity entity);

    List<SpellResponseDTO> toResponseDTOList(List<SpellEntity> entities);
}

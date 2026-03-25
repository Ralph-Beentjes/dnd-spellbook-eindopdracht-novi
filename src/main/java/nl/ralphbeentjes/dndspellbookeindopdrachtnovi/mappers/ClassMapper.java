package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.mappers;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.ClassRequestDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.ClassResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.ClassEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellbookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper(uses = {SpellMapper.class, SpellbookMapper.class})
public interface ClassMapper {

    ClassMapper INSTANCE = Mappers.getMapper(ClassMapper.class);

    @Mapping(target = "spellbooks", source = "spellbooks")
    @Mapping(target = "spells", source = "spells")
    ClassEntity toEntity(ClassRequestDTO dto, List<SpellbookEntity> spellbooks, Set<SpellEntity> spells);

    ClassResponseDTO toResponseDTO(ClassEntity entity);

    List<ClassResponseDTO> toResponseDTOList(List<ClassEntity> entities);
}

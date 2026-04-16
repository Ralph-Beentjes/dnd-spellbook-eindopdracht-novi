package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.mappers;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.classes.ClassRequestDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.classes.ClassResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.ClassEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {SpellMapper.class})
public interface ClassMapper {

    @Mapping(target = "spells", ignore = true)
    ClassEntity toEntity(ClassRequestDTO dto);

    ClassResponseDTO toResponseDTO(ClassEntity classEntity);

    List<ClassResponseDTO> toResponseDTOList(List<ClassEntity> classEntities);
}

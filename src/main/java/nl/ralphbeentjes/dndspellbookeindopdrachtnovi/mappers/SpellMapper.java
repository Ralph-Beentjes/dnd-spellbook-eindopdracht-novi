package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.mappers;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spells.SpellResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.ClassEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellbookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper(uses = {SpellbookMapper.class, ClassMapper.class})
public interface SpellMapper {

    SpellMapper INSTANCE = Mappers.getMapper(SpellMapper.class);

    @Mapping(target = "spellbooks", source = "spellbooks")
    @Mapping(target = "classes", source = "classes")
    SpellEntity toEntity(Set<SpellbookEntity> spellbooks, Set<ClassEntity> classes);

    SpellResponseDTO toResponseDTO(SpellEntity spell);

    List<SpellResponseDTO> toResponseDTO(List<SpellEntity> spells);
}

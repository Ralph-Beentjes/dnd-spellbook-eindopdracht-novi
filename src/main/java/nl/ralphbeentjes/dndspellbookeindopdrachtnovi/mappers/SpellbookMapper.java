package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.mappers;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.classes.ClassRequestDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spellbooks.SpellbookResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.ShareEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellbookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper(uses = {SpellMapper.class, ClassMapper.class})
public interface SpellbookMapper {

    SpellbookMapper INSTANCE = Mappers.getMapper(SpellbookMapper.class);

    @Mapping(target = "spells", source = "spells")
    @Mapping(target = "classes", source = "classes")
    SpellEntity toEntity(Set<SpellEntity> spells, ClassRequestDTO dto, List<ShareEntity> shares);

    SpellbookResponseDTO toResponseDTO(SpellbookEntity spellbook);

    List<SpellbookResponseDTO> toResponseDTO(List<SpellbookEntity> spellbooks);
}

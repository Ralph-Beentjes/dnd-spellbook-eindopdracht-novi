package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.mappers;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.shares.ShareResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spellbooks.SpellbookRequestDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.ShareEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {SpellbookMapper.class})
public interface ShareMapper {

    ShareMapper INSTANCE = Mappers.getMapper(ShareMapper.class);

    @Mapping(target = "spellbooks", source = "spellbooks")
    ShareEntity toEntity(SpellbookRequestDTO dto);

    ShareResponseDTO toResponseDTO(ShareEntity share);

    List<ShareEntity> toResponseDTOList(List<ShareEntity> shares);
}

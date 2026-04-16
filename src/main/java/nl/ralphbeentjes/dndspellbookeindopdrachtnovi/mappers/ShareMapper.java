package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.mappers;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.shares.ShareRequestDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.shares.ShareResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.spellbooks.SpellbookRequestDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.ShareEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SpellbookMapper.class})
public interface ShareMapper {

    @Mapping(target = "spellbook", ignore = true)
    ShareEntity toEntity(ShareRequestDTO dto);

    ShareResponseDTO toResponseDTO(ShareEntity share);

    List<ShareResponseDTO> toResponseDTOList(List<ShareEntity> shares);
}

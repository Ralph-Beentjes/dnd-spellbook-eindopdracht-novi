package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.mappers;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.userprofiles.UserProfileResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellbookEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.UserProfileEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper(uses = {SpellbookMapper.class})
public interface UserProfileMapper {

    UserProfileMapper INSTANCE = Mappers.getMapper(UserProfileMapper.class);

    @Mapping(target = "spellbooks", source = "spellbooks")
    UserProfileEntity toEntity(Set<SpellbookEntity> spellbooks);

    UserProfileResponseDTO toResponseDTO(UserProfileEntity userProfile);

    List<UserProfileResponseDTO> toResponseDTOList(List<UserProfileEntity> userProfiles);
}

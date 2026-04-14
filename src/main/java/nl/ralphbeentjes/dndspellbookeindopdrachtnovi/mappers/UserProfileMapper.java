package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.mappers;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.userprofiles.UserProfileRequestDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.userprofiles.UserProfileResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.SpellbookEntity;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.entities.UserProfileEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {

    @Mapping(target = "spellbooks", ignore = true)
    @Mapping(target = "keycloakId", ignore = true)
    UserProfileEntity toEntity(UserProfileRequestDTO dto);

    UserProfileResponseDTO toResponseDTO(UserProfileEntity userProfile);

    List<UserProfileResponseDTO> toResponseDTOList(List<UserProfileEntity> userProfiles);
}

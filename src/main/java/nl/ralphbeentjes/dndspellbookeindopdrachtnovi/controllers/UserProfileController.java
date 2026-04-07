package nl.ralphbeentjes.dndspellbookeindopdrachtnovi.controllers;

import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.userprofiles.UserProfileRequestDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.dtos.userprofiles.UserProfileResponseDTO;
import nl.ralphbeentjes.dndspellbookeindopdrachtnovi.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserProfileController {
    private final UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping
    public ResponseEntity<List<UserProfileResponseDTO>> getAllUserProfiles(){
        List<UserProfileResponseDTO> users = userProfileService.findAllUserProfiles();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfileResponseDTO> getUserProfileById(@PathVariable Long id){
        UserProfileResponseDTO user = userProfileService.findUserProfileById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserProfileResponseDTO> createUserProfile(@RequestBody UserProfileRequestDTO userProfileRequestDTO){
        UserProfileResponseDTO userProfileResponseDTO = userProfileService.createUserProfile(userProfileRequestDTO);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userProfileResponseDTO.getId()).toUri();

        return ResponseEntity.created(location).body(userProfileResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserProfileResponseDTO> updateUserProfile(@PathVariable Long id, @RequestBody UserProfileRequestDTO userProfileRequestDTO){
        UserProfileResponseDTO userProfileResponseDTO = userProfileService.updateUserProfile(id, userProfileRequestDTO);
        return new ResponseEntity<>(userProfileResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserProfileResponseDTO> deleteUserProfile(@PathVariable Long id){
        userProfileService.deleteUserProfile(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

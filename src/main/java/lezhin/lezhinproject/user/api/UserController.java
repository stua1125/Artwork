package lezhin.lezhinproject.user.api;

import lezhin.lezhinproject.user.application.UserService;
import lezhin.lezhinproject.user.domain.User;
import lezhin.lezhinproject.user.dto.UserRequestDto;
import lezhin.lezhinproject.user.dto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto) {
        User newUser = userService.saveUser(userRequestDto.toEntity());
        UserResponseDto userResponseDto = new UserResponseDto(newUser);
        return ResponseEntity.ok(userResponseDto);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }
}

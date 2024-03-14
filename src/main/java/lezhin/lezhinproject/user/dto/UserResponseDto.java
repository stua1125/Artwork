package lezhin.lezhinproject.user.dto;

import lezhin.lezhinproject.user.domain.Gender;
import lezhin.lezhinproject.user.domain.User;
import lezhin.lezhinproject.user.domain.UserType;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
    private Gender gender;
    private UserType type;

    public UserResponseDto(User newUser) {
        this.id = newUser.getId();
        this.name = newUser.getName();
        this.email = newUser.getEmail();
        this.gender = newUser.getGender();
        this.type = newUser.getType();
    }

}

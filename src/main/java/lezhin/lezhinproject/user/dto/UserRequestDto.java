package lezhin.lezhinproject.user.dto;

import lezhin.lezhinproject.user.domain.Gender;
import lezhin.lezhinproject.user.domain.User;
import lezhin.lezhinproject.user.domain.UserType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UserRequestDto {
    private String name;
    private String email;
    private String gender;
    private String type;

    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .gender(Gender.valueOf(gender))
                .type(UserType.valueOf(type))
                .build();
    }
}

package aermicioi.finlog.user.boundary;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserDto {
    String email;
    String firstName;
    String lastName;
}

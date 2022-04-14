package aermicioi.finlog.user.boundary;

import aermicioi.finlog.user.control.UserService;
import aermicioi.finlog.user.model.UserEntity;
import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
class UsersController {

    private final UserService userService;

    @PostMapping(consumes = {
            "application/json",
            "application/vnd.finlog+json",
            "application/vnd.finlog+json;v=1"
    })
    void addUser(@RequestBody @Valid final UserAddRequest request) {
        final var serviceRequest = UserService.UserAddRequest.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
        userService.addUser(serviceRequest);
    }

    @Jacksonized
    @Builder
    @Value
    @Validated
    static public class UserAddRequest {
        @NotBlank
        @Email
        @Size(max = 255)
        String email;

        @NotBlank
        @Size(min = 5)
        String password;
    }

}

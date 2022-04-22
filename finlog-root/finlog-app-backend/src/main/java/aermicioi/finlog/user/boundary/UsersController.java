package aermicioi.finlog.user.boundary;

import aermicioi.finlog.user.control.UserService;
import aermicioi.finlog.user.model.UserEntity;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.security.Principal;

import static aermicioi.finlog.common.boundary.ControllerConstants.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@SuppressWarnings("unused")
class UsersController {

    private final UserService userService;
    private final UserEntityToDtoTransformer userEntityToDtoTransformer;

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

    @GetMapping(produces = {
            JSON_TYPE,
            JSON_FINLOG_TYPE,
            JSON_FINLOG_V1_TYPE
    }, params = "email")
    UserDto getUser(@RequestParam(name = "email") final String email) {
        final UserEntity userEntity = userService.getUser(email);
        return userEntityToDtoTransformer.transform(userEntity);
    }

    @GetMapping(produces = {
            JSON_TYPE,
            JSON_FINLOG_TYPE,
            JSON_FINLOG_V1_TYPE
    }, params = "authenticated")
    UserDto getAuthenticatedUser(@RequestParam(name = "authenticated") final boolean authenticated,
                 final Principal principal) {
        if (!authenticated) {
            throw new IllegalArgumentException("Unexpected value for `authenticated` parameter");
        }

        return this.getUser(principal.getName());
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

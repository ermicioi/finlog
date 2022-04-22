package aermicioi.finlog.user.boundary;

import aermicioi.finlog.user.control.UserService;
import aermicioi.finlog.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

import static aermicioi.finlog.common.boundary.ControllerConstants.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@SuppressWarnings("unused")
class UsersController {

    private final UserService userService;
    private final UserEntityToDtoTransformer userEntityToDtoTransformer;

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

}

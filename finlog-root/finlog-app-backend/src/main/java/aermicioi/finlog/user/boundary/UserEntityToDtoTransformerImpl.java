package aermicioi.finlog.user.boundary;

import aermicioi.finlog.user.model.UserEntity;
import org.springframework.stereotype.Component;

@Component
class UserEntityToDtoTransformerImpl implements UserEntityToDtoTransformer {

    @Override
    public UserDto transform(final UserEntity userEntity) {
        return UserDto.builder()
                .email(userEntity.getEmail())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .build();
    }
}

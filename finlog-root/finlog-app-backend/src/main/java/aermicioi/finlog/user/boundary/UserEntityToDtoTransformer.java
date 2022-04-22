package aermicioi.finlog.user.boundary;

import aermicioi.finlog.common.boundary.Transformer;
import aermicioi.finlog.user.model.UserEntity;

public interface UserEntityToDtoTransformer extends Transformer<UserEntity, UserDto> {
}

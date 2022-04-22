package aermicioi.finlog.user.control;

import aermicioi.finlog.user.model.UserEntity;

public interface UserService {

    UserEntity getUser(String email);

}

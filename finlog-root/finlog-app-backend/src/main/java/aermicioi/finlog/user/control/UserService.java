package aermicioi.finlog.user.control;

import aermicioi.finlog.user.model.UserEntity;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

public interface UserService {

    void addUser(UserAddRequest request);

    @Builder
    @Value
    class UserAddRequest {
        @NonNull
        String email;

        @NonNull
        String password;
    }
}

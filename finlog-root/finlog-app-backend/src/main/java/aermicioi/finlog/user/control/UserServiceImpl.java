package aermicioi.finlog.user.control;

import aermicioi.finlog.common.NotFoundException;
import aermicioi.finlog.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void addUser(final UserAddRequest request) {
        final var userEntity = UserEntity.builder()
                .email(request.getEmail())
                .password(request.getPassword()) // TODO Add hashing of the password
                .build();
        userRepository.save(userEntity);
    }

    @Override
    public UserEntity getUser(final String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Cannot find user with email '%s'", email));
    }

}

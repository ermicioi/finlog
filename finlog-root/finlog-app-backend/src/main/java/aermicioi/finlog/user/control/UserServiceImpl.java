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
    public UserEntity getUser(final String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Cannot find user with email '%s'", email));
    }

}

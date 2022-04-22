package aermicioi.finlog.core.security;

import aermicioi.finlog.user.control.UserRepository;
import aermicioi.finlog.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

@RequiredArgsConstructor
class FinlogUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        final UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(UnknownUserException::new);
        return new User(userEntity.getEmail(), userEntity.getPassword(), Collections.emptyList());
    }
}

package vlsu.ProducerCentr.serverside.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vlsu.ProducerCentr.serverside.config.ApplicationProperties;
import vlsu.ProducerCentr.serverside.model.User;
import vlsu.ProducerCentr.serverside.repository.UserRepository;
import vlsu.ProducerCentr.serverside.service.RoleService;
import vlsu.ProducerCentr.serverside.service.UserService;
import vlsu.ProducerCentr.serverside.utils.jwt.JwtProvider;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final ApplicationProperties applicationProperties;
    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final RoleService roleService;
    private final JwtProvider jwtProvider;

    @Override
    public User findByLogin(String login) {
        return repository.findByEmail(login);
    }







    @FunctionalInterface
    private interface ChangePersonalInfoFunction {
        void change(User user, String newInfo);
    }
}

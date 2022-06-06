package vlsu.ProducerCentr.serverside.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vlsu.ProducerCentr.serverside.model.User;
import vlsu.ProducerCentr.serverside.repository.UserRepository;
import vlsu.ProducerCentr.serverside.service.UserService;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        try {
            User user = repository.findByLogin(login);
            Set<GrantedAuthority> ga = new HashSet<>();
            ga.add(new SimpleGrantedAuthority(user.getRole().getTitle().toString()));
            return new org.springframework.security.core.userdetails.User(
                    login,
                    user.getPassword(),
                    ga
            );
        } catch (NullPointerException e) {
            throw new UsernameNotFoundException("Login do not exist");
        }
    }
}

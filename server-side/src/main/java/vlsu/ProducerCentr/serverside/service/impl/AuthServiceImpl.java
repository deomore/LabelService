package vlsu.ProducerCentr.serverside.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vlsu.ProducerCentr.serverside.dto.AuthRequestDto;
import vlsu.ProducerCentr.serverside.dto.AuthResponseDto;
import vlsu.ProducerCentr.serverside.model.User;
import vlsu.ProducerCentr.serverside.service.AuthService;
import vlsu.ProducerCentr.serverside.service.UserService;
import vlsu.ProducerCentr.serverside.utils.exception.BusinessException;
import vlsu.ProducerCentr.serverside.utils.exception.ErrorCode;
import vlsu.ProducerCentr.serverside.utils.jwt.Claim;
import vlsu.ProducerCentr.serverside.utils.jwt.JwtProvider;

import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final JwtProvider jwtProvider;
    private final UserService userService;
    private final PasswordEncoder encoder;

    @Override
    public AuthResponseDto createToken(AuthRequestDto requestDto) {
        User user = userService.findByLogin(requestDto.getLogin());;
        if(Objects.nonNull(user) && encoder.matches(requestDto.getPassword(), user.getPassword())) {
            return new AuthResponseDto().setToken(jwtProvider.generateToken(user)).setRoles(user.getRoles().stream().map(item -> item.getTitle().toString()).collect(Collectors.toList()));
        } else {
            throw new BusinessException().setCode(ErrorCode.WRONG_CREDENTIALS);
        }
    }
}

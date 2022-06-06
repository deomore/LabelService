package vlsu.ProducerCentr.serverside.service;

import vlsu.ProducerCentr.serverside.dto.auth.AuthRequestDto;
import vlsu.ProducerCentr.serverside.dto.auth.AuthResponseDto;

import java.util.UUID;

public interface AuthService {
    AuthResponseDto createToken(AuthRequestDto requestDto);
}

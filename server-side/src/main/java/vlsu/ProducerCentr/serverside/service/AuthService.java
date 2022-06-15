package vlsu.ProducerCentr.serverside.service;



import vlsu.ProducerCentr.serverside.dto.AuthRequestDto;
import vlsu.ProducerCentr.serverside.dto.AuthResponseDto;

import java.util.UUID;

public interface AuthService {
    AuthResponseDto createToken(AuthRequestDto requestDto);
}

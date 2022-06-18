package vlsu.ProducerCentr.serverside.utils.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import vlsu.ProducerCentr.serverside.utils.jwt.JwtProvider;

@Component
@RequiredArgsConstructor
public class AuthHelper {
	private final JwtProvider jwtProvider;

	public String getUserEmail() {
		return jwtProvider.getEmailFromToken(SecurityContextHolder.getContext().getAuthentication().getDetails().toString());
	}
}

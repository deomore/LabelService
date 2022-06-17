package vlsu.ProducerCentr.serverside.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import vlsu.ProducerCentr.serverside.dto.AddConcertDto;
import vlsu.ProducerCentr.serverside.model.Concert;
import vlsu.ProducerCentr.serverside.model.User;
import vlsu.ProducerCentr.serverside.repository.ArtistRepository;
import vlsu.ProducerCentr.serverside.repository.ConcertRepository;
import vlsu.ProducerCentr.serverside.repository.UserRepository;
import vlsu.ProducerCentr.serverside.service.ConcertService;
import vlsu.ProducerCentr.serverside.utils.jwt.JwtProvider;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ConcertServiceImpl implements ConcertService {
	private final ConcertRepository concertRepository;
	private final UserRepository userRepository;
	private final JwtProvider jwtProvider;
	private final ArtistRepository artistRepository;

	@Override
	@Transactional
	public Concert addConcert(AddConcertDto addConcertDto) {
		User user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getDetails().toString());
		Concert concert = new Concert();
		concert.setArtist(artistRepository.findById(addConcertDto.getArtistId()).get());
		concert.setCity(addConcertDto.getCity());
		concert.setUser(user);
		concert.setPrice(addConcertDto.getPrice());
		concert.setDate(addConcertDto.getDate());
		return concertRepository.save(concert);
	}
}

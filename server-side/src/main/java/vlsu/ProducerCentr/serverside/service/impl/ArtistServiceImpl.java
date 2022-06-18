package vlsu.ProducerCentr.serverside.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import vlsu.ProducerCentr.serverside.dto.AddArtistDto;
import vlsu.ProducerCentr.serverside.model.Artist;
import vlsu.ProducerCentr.serverside.model.Concert;
import vlsu.ProducerCentr.serverside.model.User;
import vlsu.ProducerCentr.serverside.repository.ArtistRepository;
import vlsu.ProducerCentr.serverside.repository.ConcertRepository;
import vlsu.ProducerCentr.serverside.repository.UserRepository;
import vlsu.ProducerCentr.serverside.service.ArtistService;
import vlsu.ProducerCentr.serverside.utils.exception.AuthHelper;
import vlsu.ProducerCentr.serverside.utils.jwt.JwtProvider;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;


@RequiredArgsConstructor
@Service
public class ArtistServiceImpl implements ArtistService {
	private final ArtistRepository artistRepository;
	private final UserRepository userRepository;
	private final ConcertRepository concertRepository;
	private final JwtProvider jwtProvider;

	private final AuthHelper authHelper;
	@Override
	@Transactional
	public Artist addArtist(AddArtistDto addArtistDto) {
		Artist artist = new Artist();
		String userEmail = jwtProvider.getEmailFromToken(SecurityContextHolder.getContext().getAuthentication().getDetails().toString());
		User user = userRepository.findByEmail(userEmail);
		artist.setFio(addArtistDto.getFio());
		artist.setName(addArtistDto.getName());
		artist.setGenre(addArtistDto.getGenre());
		artist.setUser(user);
		return artistRepository.save(artist);
	}

	@Override
	@Transactional
	public List<Artist> getArtist() {
		User user = userRepository.findByEmail(authHelper.getUserEmail());
		List<Concert> concerts = concertRepository.findAll();
		concerts = concerts.stream()
				.filter(concert -> concert.getPrice() > 140000 && Period.between(concert.getDate(), LocalDate.now().minusMonths(3)).getMonths() < 3)
				.collect(Collectors.toList());
		List<Artist> allArtists = concerts.stream().map(Concert::getArtist).collect(Collectors.toList());
		return allArtists.stream()
				.filter(item -> item.getUser().equals(user))
				.filter(item -> item.getContract().getType())
				.collect(Collectors.toList());
 	}
}

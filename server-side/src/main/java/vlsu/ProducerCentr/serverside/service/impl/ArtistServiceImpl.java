package vlsu.ProducerCentr.serverside.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import vlsu.ProducerCentr.serverside.dto.AddArtistDto;
import vlsu.ProducerCentr.serverside.model.Artist;
import vlsu.ProducerCentr.serverside.model.User;
import vlsu.ProducerCentr.serverside.repository.ArtistRepository;
import vlsu.ProducerCentr.serverside.repository.UserRepository;
import vlsu.ProducerCentr.serverside.service.ArtistService;
import vlsu.ProducerCentr.serverside.utils.jwt.JwtProvider;

import javax.transaction.Transactional;


@RequiredArgsConstructor
@Service
public class ArtistServiceImpl implements ArtistService {
	private final ArtistRepository artistRepository;
	private final UserRepository userRepository;
	private final JwtProvider jwtProvider;
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
}

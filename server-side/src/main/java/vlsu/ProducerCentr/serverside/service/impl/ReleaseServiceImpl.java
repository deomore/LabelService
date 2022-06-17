package vlsu.ProducerCentr.serverside.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import vlsu.ProducerCentr.serverside.dto.AddReleaseDto;
import vlsu.ProducerCentr.serverside.model.Artist;
import vlsu.ProducerCentr.serverside.model.Release;
import vlsu.ProducerCentr.serverside.model.Source;
import vlsu.ProducerCentr.serverside.model.User;
import vlsu.ProducerCentr.serverside.repository.ArtistRepository;
import vlsu.ProducerCentr.serverside.repository.ReleaseRepository;
import vlsu.ProducerCentr.serverside.repository.SourceRepository;
import vlsu.ProducerCentr.serverside.repository.UserRepository;
import vlsu.ProducerCentr.serverside.service.ReleaseService;
import vlsu.ProducerCentr.serverside.utils.jwt.JwtProvider;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ReleaseServiceImpl implements ReleaseService {
	private final ReleaseRepository releaseRepository;
	private final SourceRepository sourceRepository;
	private final ArtistRepository artistRepository;
	private final UserRepository userRepository;
	private final JwtProvider jwtProvider;
	@Override
	@Transactional
	public Release addRelease(AddReleaseDto addReleaseDto) {
		Source source = sourceRepository.findById(addReleaseDto.getSourceId()).get();
		Artist artist = artistRepository.findById(addReleaseDto.getArtistId()).get();
		String email = jwtProvider.getEmailFromToken(SecurityContextHolder.getContext().getAuthentication().getDetails().toString());
		User user = userRepository.findByEmail(email);
		Release release = new Release();
		release.setReleaseUrl(addReleaseDto.getReleaseUrl());
		release.setGenre(addReleaseDto.getGenre());
		release.setName(addReleaseDto.getName());
		release.setSource(source);
		release.setUser(user);
		release.setArtist(artist);
		return  releaseRepository.save(release);
	}
}

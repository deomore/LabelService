package vlsu.psycho.serverside;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import vlsu.ProducerCentr.serverside.model.Artist;
import vlsu.ProducerCentr.serverside.model.Concert;
import vlsu.ProducerCentr.serverside.model.Contract;
import vlsu.ProducerCentr.serverside.model.Gender;
import vlsu.ProducerCentr.serverside.model.Release;
import vlsu.ProducerCentr.serverside.model.Role;
import vlsu.ProducerCentr.serverside.model.RoleTitle;
import vlsu.ProducerCentr.serverside.model.Source;
import vlsu.ProducerCentr.serverside.model.User;
import vlsu.ProducerCentr.serverside.repository.ArtistRepository;
import vlsu.ProducerCentr.serverside.repository.ConcertRepository;
import vlsu.ProducerCentr.serverside.repository.UserRepository;
import vlsu.ProducerCentr.serverside.service.ArtistService;
import vlsu.ProducerCentr.serverside.service.impl.ArtistServiceImpl;
import vlsu.ProducerCentr.serverside.utils.exception.AuthHelper;
import vlsu.ProducerCentr.serverside.utils.jwt.JwtProvider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import  static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@ExtendWith(MockitoExtension.class)
class TestClass {
	private ArtistService artistService;

	@Mock
	private ArtistRepository artistRepository;
	@Mock
	private UserRepository userRepository;
	@Mock
	private ConcertRepository concertRepository;
	@Mock
	private JwtProvider jwtProvider;

	@Mock
	private AuthHelper authHelper;

	@BeforeEach
	void init() {
		artistService = new ArtistServiceImpl(artistRepository, userRepository, concertRepository, jwtProvider, authHelper);
	}

	@Test
	void getArtistsSuccess() {
		when(authHelper.getUserEmail()).thenReturn(getUserEmail());
		when(userRepository.findByEmail(any())).thenReturn(getUser());
		List<Concert> concerts = new ArrayList<>();
		for(int i = 1; i < 4; i++) {
			Concert concert = getConcert();
			concert.setId(i);
			concerts.add(concert);
		}
		concerts.get(1).setPrice(1f);
		concerts.get(2).setPrice(2f);
		when(concertRepository.findAll()).thenReturn(concerts);

		Artist expected = getArtist();
		List<Artist> actualList = artistService.getArtist();
		assertEquals(expected, actualList.get(0));
	}

	private String getUserEmail() {
		return "user";
	}

	private Concert getConcert() {
		Concert concert = new Concert();
		concert.setArtist(getArtist());
		concert.setCity("city");
		concert.setDate(LocalDate.now());
		concert.setPrice(1500000f);
		concert.setRelease(getRelease());
		concert.setUser(getUser());
		return concert;
	}

	private Release getRelease() {
		Release release = new Release();
		release.setId(1);
		release.setName("name");
		release.setGenre("genre");
		release.setReleaseUrl("release url");
		release.setSource(getSource());
		release.setUser(getUser());
		release.setArtist(getArtist());
		return release;
	}

	private Source getSource() {
		Source source = new Source();
		source.setId(1);
		source.setSource1Url("1 url");
		source.setSource2Url("2 url");
		source.setSource3Url("3 url");
		return source;
	}

	private Artist getArtist() {
		Artist artist = new Artist();
		artist.setId(1);
		artist.setName("artist name");
		artist.setFio("fio");
		artist.setGenre("genre");
		artist.setUser(getUser());
		artist.setContract(getContracts());
		return artist;
	}

	private Contract getContracts() {
		Contract contract = new Contract();
		contract.setId(1);
		contract.setDate(LocalDate.now());
		contract.setType(true);
		contract.setContractUrl("contract url");
		return contract;
	}

	private User getUser() {
		User user = new User();
		user.setId(1);
		user.setEmail(getUserEmail());
		user.setBirthDate(LocalDate.now());
		user.setGender(Gender.MALE);
		user.setPassword("user");
		user.setRoles(Collections.singletonList(getRole()));
		return user;
	}

	private Role getRole() {
		Role role = new Role();
		role.setId(1);
		role.setTitle(RoleTitle.ROLE_PRODUCER);
		return role;
	}
}

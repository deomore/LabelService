package vlsu.ProducerCentr.serverside.service;

import vlsu.ProducerCentr.serverside.dto.AddArtistDto;
import vlsu.ProducerCentr.serverside.model.Artist;

public interface ArtistService {
	Artist addArtist(AddArtistDto addArtistDto);
}

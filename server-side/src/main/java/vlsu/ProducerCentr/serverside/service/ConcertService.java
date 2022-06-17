package vlsu.ProducerCentr.serverside.service;

import vlsu.ProducerCentr.serverside.dto.AddConcertDto;
import vlsu.ProducerCentr.serverside.model.Concert;

public interface ConcertService {
	Concert addConcert(AddConcertDto addConcertDto);
}

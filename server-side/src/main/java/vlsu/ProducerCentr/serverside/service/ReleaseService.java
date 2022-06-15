package vlsu.ProducerCentr.serverside.service;

import vlsu.ProducerCentr.serverside.dto.AddReleaseDto;
import vlsu.ProducerCentr.serverside.model.Release;

public interface ReleaseService {
	Release addRelease(AddReleaseDto addReleaseDto);
}

package vlsu.ProducerCentr.serverside.service;

import vlsu.ProducerCentr.serverside.dto.AddDemoDto;
import vlsu.ProducerCentr.serverside.dto.BindDemoWithContractDto;
import vlsu.ProducerCentr.serverside.model.DemoDrop;

public interface DemoDropService {
	DemoDrop addDemoDrop(AddDemoDto addDemoDto);

	DemoDrop bindWithContract(BindDemoWithContractDto bindDemoWithContractDto);
}

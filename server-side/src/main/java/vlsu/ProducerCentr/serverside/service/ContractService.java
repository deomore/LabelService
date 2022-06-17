package vlsu.ProducerCentr.serverside.service;

import vlsu.ProducerCentr.serverside.dto.AddContractDto;
import vlsu.ProducerCentr.serverside.model.Contract;

public interface ContractService {
	Contract addContract(AddContractDto addContractDto);
}

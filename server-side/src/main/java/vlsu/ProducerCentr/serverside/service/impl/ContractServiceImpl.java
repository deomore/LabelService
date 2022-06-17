package vlsu.ProducerCentr.serverside.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vlsu.ProducerCentr.serverside.dto.AddConcertDto;
import vlsu.ProducerCentr.serverside.dto.AddContractDto;
import vlsu.ProducerCentr.serverside.model.Concert;
import vlsu.ProducerCentr.serverside.model.Contract;
import vlsu.ProducerCentr.serverside.repository.ContractRepository;
import vlsu.ProducerCentr.serverside.service.ConcertService;
import vlsu.ProducerCentr.serverside.service.ContractService;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {
	private final ContractRepository contractRepository;

	@Override
	@Transactional
	public Contract addContract(AddContractDto addContractDto) {
		Contract contract = new Contract();
		contract.setContractUrl(addContractDto.getContractUrl());
		contract.setType(addContractDto.getType());
		contract.setDate(addContractDto.getDate());
		return contractRepository.save(contract);
	}
}

package vlsu.ProducerCentr.serverside.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vlsu.ProducerCentr.serverside.dto.AddDemoDto;
import vlsu.ProducerCentr.serverside.dto.BindDemoWithContractDto;
import vlsu.ProducerCentr.serverside.model.Contract;
import vlsu.ProducerCentr.serverside.model.DemoDrop;
import vlsu.ProducerCentr.serverside.repository.ContractRepository;
import vlsu.ProducerCentr.serverside.repository.DemoDropRepository;
import vlsu.ProducerCentr.serverside.service.DemoDropService;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class DemoDropServiceImpl implements DemoDropService {
	private final DemoDropRepository demoDropRepository;
	private final ContractRepository contractRepository;

	@Override
	@Transactional
	public DemoDrop addDemoDrop(AddDemoDto addDemoDto) {
		DemoDrop demoDrop = new DemoDrop();
		demoDrop.setDemoUrl(addDemoDto.getDemoUrl());
		demoDrop.setDescription(addDemoDto.getDescription());
		demoDrop.setMail(addDemoDto.getMail());
		return demoDropRepository.save(demoDrop);
	}

	@Override
	@Transactional
	public DemoDrop bindWithContract(BindDemoWithContractDto bindDemoWithContractDto) {
		DemoDrop demoDrop = demoDropRepository.findById(bindDemoWithContractDto.getDemoDropId()).get();
		Contract contract = contractRepository.findById(bindDemoWithContractDto.getContractId()).get();
		demoDrop.setContract(contract);
		return demoDrop;
	}
}

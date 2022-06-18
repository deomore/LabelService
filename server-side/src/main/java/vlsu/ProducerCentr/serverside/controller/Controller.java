package vlsu.ProducerCentr.serverside.controller;

import lombok.RequiredArgsConstructor;
import org.dom4j.rule.Mode;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import vlsu.ProducerCentr.serverside.dto.AddArtistDto;
import vlsu.ProducerCentr.serverside.dto.AddConcertDto;
import vlsu.ProducerCentr.serverside.dto.AddContractDto;
import vlsu.ProducerCentr.serverside.dto.AddDemoDto;
import vlsu.ProducerCentr.serverside.dto.AddReleaseDto;
import vlsu.ProducerCentr.serverside.dto.BindDemoWithContractDto;
import vlsu.ProducerCentr.serverside.model.Artist;
import vlsu.ProducerCentr.serverside.model.Concert;
import vlsu.ProducerCentr.serverside.model.Contract;
import vlsu.ProducerCentr.serverside.model.DemoDrop;
import vlsu.ProducerCentr.serverside.model.Release;
import vlsu.ProducerCentr.serverside.repository.ArtistRepository;
import vlsu.ProducerCentr.serverside.service.ArtistService;
import vlsu.ProducerCentr.serverside.service.ConcertService;
import vlsu.ProducerCentr.serverside.service.ContractService;
import vlsu.ProducerCentr.serverside.service.DemoDropService;
import vlsu.ProducerCentr.serverside.service.ReleaseService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {
	private final ReleaseService releaseService;
	private final ArtistService artistService;
	private final ConcertService concertService;
	private final DemoDropService demoDropService;

	private final ContractService contractService;

	@PostMapping("/addRelease")
	@PreAuthorize("permitAll()")
	public Release addRelease(@RequestBody AddReleaseDto addReleaseDto) {
		return releaseService.addRelease(addReleaseDto);
	}

	@PostMapping("/addArtist")
	@PreAuthorize("permitAll()")
	public Artist addArtist(@RequestBody AddArtistDto addArtistDto) {
		return artistService.addArtist(addArtistDto);
	}

	@PostMapping("/addConcert")
	@PreAuthorize("permitAll()")
	public Concert addConcert(@RequestBody AddConcertDto addConcertDto) {
		return concertService.addConcert(addConcertDto);
	}

	@PostMapping("/addDemoDrop")
	@PreAuthorize("permitAll()")
	public DemoDrop addDrop(@RequestBody AddDemoDto addDemoDto) {
		return demoDropService.addDemoDrop(addDemoDto);
	}

	@PostMapping("/addContract")
	@PreAuthorize("permitAll()")
	public Contract addContract(@RequestBody AddContractDto addContractDto) {
		return contractService.addContract(addContractDto);
	}

	@PostMapping("/bind")
	@PreAuthorize("permitAll()")
	public DemoDrop bindWithContract(@RequestBody BindDemoWithContractDto bindDemoWithContractDto) {
		return demoDropService.bindWithContract(bindDemoWithContractDto);
	}

	@GetMapping("/getArtist")
	@PreAuthorize("permitAll()")
	public List<Artist> getArtists() {
		return artistService.getArtist();
	}
}

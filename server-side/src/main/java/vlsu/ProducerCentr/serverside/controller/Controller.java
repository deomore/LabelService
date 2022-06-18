package vlsu.ProducerCentr.serverside.controller;

import jdk.jfr.Percentage;
import lombok.RequiredArgsConstructor;
import org.dom4j.rule.Mode;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
import vlsu.ProducerCentr.serverside.repository.ConcertRepository;
import vlsu.ProducerCentr.serverside.repository.ContractRepository;
import vlsu.ProducerCentr.serverside.repository.DemoDropRepository;
import vlsu.ProducerCentr.serverside.repository.ReleaseRepository;
import vlsu.ProducerCentr.serverside.repository.SourceRepository;
import vlsu.ProducerCentr.serverside.repository.UserRepository;
import vlsu.ProducerCentr.serverside.service.ArtistService;
import vlsu.ProducerCentr.serverside.service.ConcertService;
import vlsu.ProducerCentr.serverside.service.ContractService;
import vlsu.ProducerCentr.serverside.service.DemoDropService;
import vlsu.ProducerCentr.serverside.service.ReleaseService;

import java.util.List;
import javax.transaction.Transactional;

@RestController
@RequiredArgsConstructor
public class Controller {
	private final ReleaseService releaseService;
	private final ArtistService artistService;
	private final ConcertService concertService;
	private final DemoDropService demoDropService;

	private final ReleaseRepository releaseRepository;
	private final ArtistRepository artistRepository;
	private final ConcertRepository concertRepository;
	private final ContractRepository contractRepository;
	private final DemoDropRepository demoDropRepository;
	private final SourceRepository sourceRepository;
	private final UserRepository userRepository;

	private final ContractService contractService;

	@PostMapping("/addRelease")
	@PreAuthorize("permitAll()")
	public Release addRelease(@RequestBody AddReleaseDto addReleaseDto) {
		return releaseService.addRelease(addReleaseDto);
	}

	@PutMapping("/updateRelease/{id}")
	@PreAuthorize("permitAl()")
	@Transactional
	public Release updateRelease(@RequestBody AddReleaseDto addReleaseDto, @PathVariable(name = "id") int id) {
		Release release = releaseRepository.findById(id).get();
		release.setArtist(artistRepository.findById(addReleaseDto.getArtistId()).get());
		release.setReleaseUrl(addReleaseDto.getReleaseUrl());
		release.setGenre(addReleaseDto.getGenre());
		release.setName(addReleaseDto.getName());
		release.setSource(sourceRepository.findById(addReleaseDto.getSourceId()).get());
		releaseRepository.save(release);
		return release;
	}

	@GetMapping("/getRelease/{id}")
	@PreAuthorize("permitAll()")
	public Release getReleaseById(@PathVariable int id) {
		return releaseRepository.findById(id).get();
	}

	@GetMapping("/getAllReleases")
	@PreAuthorize("permitAll()")
	public List<Release> getAllReleases() {
		return releaseRepository.findAll();
	}

	@DeleteMapping("/deleteRelease/{id}")
	@Transactional
	@PreAuthorize("permitAll()")
	public void deleteRelease(@PathVariable int id) {
		releaseRepository.deleteById(id);
	}

	@PostMapping("/addArtist")
	@PreAuthorize("permitAll()")
	public Artist addArtist(@RequestBody AddArtistDto addArtistDto) {
		return artistService.addArtist(addArtistDto);
	}

	@PutMapping("/updateArtist/{id}")
	@PreAuthorize("permitAll()")
	@Transactional
	public Artist updateArtis(@PathVariable int id, @RequestBody AddArtistDto addArtistDto) {
		Artist artist = artistRepository.findById(id).get();
		artist.setFio(addArtistDto.getFio());
		artist.setGenre(addArtistDto.getGenre());
		artist.setName(addArtistDto.getName());
		artist.setContract(contractRepository.findById(addArtistDto.getContractId()).get());
		artistRepository.save(artist);
		return artist;
	}

	@GetMapping("/getArtist/{id}")
	@PreAuthorize("permitAll()")
	public Artist getArtistById(@PathVariable int id) {
		return artistRepository.findById(id).get();
	}

	@GetMapping("/getAllArtists")
	@PreAuthorize("permitAll()")
	public List<Artist> getAllArtists() {
		return artistRepository.findAll();
	}

	@DeleteMapping("/deleteArtist/{id}")
	@Transactional
	@PreAuthorize("permitAll()")
	public void deleteArtist(@PathVariable int id) {
		artistRepository.deleteById(id);
	}

	@PostMapping("/addConcert")
	@PreAuthorize("permitAll()")
	public Concert addConcert(@RequestBody AddConcertDto addConcertDto) {
		return concertService.addConcert(addConcertDto);
	}

	@PutMapping("/updateConcert/{id}")
	@Transactional
	@PreAuthorize("permitAll()")
	public Concert updateConcert(@PathVariable int id, @RequestBody AddConcertDto addConcertDto) {
		Concert concert = concertRepository.findById(id).get();
		concert.setPrice(addConcertDto.getPrice());
		concert.setDate(addConcertDto.getDate());
		concert.setCity(addConcertDto.getCity());
		concert.setArtist(artistRepository.findById(addConcertDto.getArtistId()).get());
		concertRepository.save(concert);
		return concert;
	}

	@GetMapping("/getConcert/{id}")
	@PreAuthorize("permitAll()")
	public Concert getConcertById(@PathVariable int id) {
		return concertRepository.findById(id).get();
	}

	@GetMapping("/getAllConcerts")
	@PreAuthorize("permitAll()")
	public List<Concert> getAllConcerts() {
		return concertRepository.findAll();
	}

	@GetMapping("/deleteConcert/{id}")
	@PreAuthorize("permitAll()")
	@Transactional
	public void deleteConcert(@PathVariable int id) {
		concertRepository.deleteById(id);
	}

	@PostMapping("/addDemoDrop")
	@PreAuthorize("permitAll()")
	public DemoDrop addDrop(@RequestBody AddDemoDto addDemoDto) {
		return demoDropService.addDemoDrop(addDemoDto);
	}

	@PutMapping("/updateMapping/{id}")
	@Transactional
	@PreAuthorize("permitAll()")
	public DemoDrop updateDemoDrop(@PathVariable int id, @RequestBody AddDemoDto addDemoDto) {
		DemoDrop demoDrop = demoDropRepository.findById(id).get();
		demoDrop.setDemoUrl(addDemoDto.getDemoUrl());
		demoDrop.setMail(addDemoDto.getMail());
		demoDrop.setDescription(addDemoDto.getDescription());
		demoDropRepository.save(demoDrop);
		return demoDrop;
	}

	@GetMapping("/getDemoDrop/{id}")
	@PreAuthorize("permitAll()")
	public DemoDrop getDemoDrop(@PathVariable int id) {
		return demoDropRepository.findById(id).get();
	}

	@GetMapping("/getAllDemoDrop")
	public List<DemoDrop> getAllDemoDrop() {
		return demoDropRepository.findAll();
	}

	@DeleteMapping("/deleteDemoDrop/{id}")
	@PreAuthorize("permitAll()")
	public void deleteDemoDrop(@PathVariable int id) {
		demoDropRepository.deleteById(id);
	}

	@PostMapping("/addContract")
	@PreAuthorize("permitAll()")
	public Contract addContract(@RequestBody AddContractDto addContractDto) {
		return contractService.addContract(addContractDto);
	}

	@PutMapping("/updateContract/{id}")
	@PreAuthorize("permitAll()")
	@Transactional
	public Contract updateContract(@PathVariable int id, @RequestBody AddContractDto addContractDto) {
		Contract contract = contractRepository.findById(id).get();
		contract.setContractUrl(addContractDto.getContractUrl());
		contract.setType(addContractDto.getType());
		contract.setDate(addContractDto.getDate());
		contractRepository.save(contract);
		return contract;
	}

	@GetMapping("/getContract/{id}")
	@PreAuthorize("permitAll()")
	public Contract getContract(@PathVariable int id) {
		return contractRepository.findById(id).get();
	}

	@GetMapping("/getAllContracts")
	@PreAuthorize("permitAll()")
	public List<Contract> getContracts() {
		return contractRepository.findAll();
	}

	@DeleteMapping("/deleteContract/{id}")
	@PreAuthorize("permitAll()")
	@Transactional
	public void deleteContract(@PathVariable int id) {
		contractRepository.deleteById(id);
	}

	@PostMapping("/bind")
	@PreAuthorize("permitAll()")
	public DemoDrop bindWithContract(@RequestBody BindDemoWithContractDto bindDemoWithContractDto) {
		return demoDropService.bindWithContract(bindDemoWithContractDto);
	}

}

package vlsu.ProducerCentr.serverside.controller;

import lombok.RequiredArgsConstructor;
import org.dom4j.rule.Mode;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import vlsu.ProducerCentr.serverside.dto.AddArtistDto;
import vlsu.ProducerCentr.serverside.dto.AddReleaseDto;
import vlsu.ProducerCentr.serverside.repository.ArtistRepository;
import vlsu.ProducerCentr.serverside.service.ArtistService;
import vlsu.ProducerCentr.serverside.service.ReleaseService;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class Controller {
	private final ReleaseService releaseService;
	private final ArtistService artistService;

	@PostMapping("/addRelease")
	public ModelAndView addRelease(@RequestBody AddReleaseDto addReleaseDto) {
		ModelAndView modelAndView = new ModelAndView("AddResult");
		modelAndView.addObject("release", releaseService.addRelease(addReleaseDto));
		return modelAndView;
	}

	@PostMapping("/addArtist")
	public ModelAndView addArtist(@RequestBody AddArtistDto addArtistDto) {
		ModelAndView modelAndView = new ModelAndView("AddResult");
		modelAndView.addObject("artist", artistService.addArtist(addArtistDto));
		return modelAndView;
	}
}

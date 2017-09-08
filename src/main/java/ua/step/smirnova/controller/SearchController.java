package ua.step.smirnova.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ua.step.smirnova.entities.Album;
import ua.step.smirnova.service.AlbumServiceImpl;
import ua.step.smirnova.service.ArtistServiceImpl;
import ua.step.smirnova.service.GenreServiceImpl;

@RestController
public class SearchController {

	private AlbumServiceImpl albumService;
	private ArtistServiceImpl artistService;
	private GenreServiceImpl genreService;

	@Autowired
	public SearchController(AlbumServiceImpl albumService, ArtistServiceImpl artistService,
			GenreServiceImpl genreService) {
		this.albumService = albumService;
		this.artistService = artistService;
		this.genreService = genreService;
	}

	@GetMapping(value = "/search/{item}")
	public Map<String,Object> getList(@PathVariable String item) {
		Map<String,Object> result = new HashMap<>();
		result.put("albums", albumService.findAllByTitle(item));
		result.put("artists", artistService.findAllByName(item));
		return result;
	}

}

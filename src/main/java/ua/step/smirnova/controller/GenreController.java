package ua.step.smirnova.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ua.step.smirnova.entities.Genre;
import ua.step.smirnova.service.AlbumServiceImpl;
import ua.step.smirnova.service.GenreServiceImpl;

@RestController
public class GenreController {

	private GenreServiceImpl genreService;
	private AlbumServiceImpl albumService;

	@Autowired(required = true)
	public void setAuthorService(GenreServiceImpl genreService, AlbumServiceImpl albumService) {
		this.genreService = genreService;
		this.albumService = albumService;
	}

	@GetMapping(value = "/genres")
	public List<Genre> getList() {
		return genreService.getAll();
	}
	
	@GetMapping(value = "/genre/{id}")
	public List<Genre> getByGenre(@PathVariable int id) {
		return albumService.getAllByGenreId(id);
	}
}

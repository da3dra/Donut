package ua.step.smirnova.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ua.step.smirnova.entities.Artist;
import ua.step.smirnova.jsonwrappers.AlbumDTO;
import ua.step.smirnova.service.ArtistService;

@Controller
public class ArtistController {
	private ArtistService artistService;

	@Autowired(required = true)
	public void setAuthorService(ArtistService artistService) {
		this.artistService = artistService;
	}

	@GetMapping(value = "/artists")
	public ResponseEntity<?> getList() {
		return ResponseEntity.ok(artistService.getAll());
	}
	
}

package ua.step.smirnova.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ua.step.smirnova.entities.Album;
import ua.step.smirnova.repository.AlbumRepository;

@RestController
public class AlbumController {

	private AlbumRepository albumRepository;

	@Autowired(required = true)
	public void setAuthorService(AlbumRepository albumRepository) {
		this.albumRepository = albumRepository;
	}

	@GetMapping(value = "/albums/{page}")
	public Page<Album> getList(@PathVariable int page) {
	List<Album>list = new ArrayList<>();
		return albumRepository.findAll(new PageRequest(0, 18));
	}

	
}

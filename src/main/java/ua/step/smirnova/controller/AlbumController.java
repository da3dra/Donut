package ua.step.smirnova.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ua.step.smirnova.entities.Album;
import ua.step.smirnova.entities.Artist;
import ua.step.smirnova.service.AlbumService;

@RestController
public class AlbumController {

	private AlbumService albumService;

	@Autowired(required = true)
	public void setAuthorService(AlbumService albumService) {
		this.albumService = albumService;
	}

	@GetMapping(value = "/albums/{page}")
	public Page<Album> getList(@PathVariable int page) {
		return albumService.getPage(new PageRequest(0, 18));
	}

	@GetMapping(value = "/albums/new")
	public Page<Album> getNew() {
		return albumService.getPage(new PageRequest(0, 4));
	}
	
	@GetMapping("/album/{id}")
	public ResponseEntity<?> getAlbum(@PathVariable int id) {
		Album album = albumService.get(id);
		return ResponseEntity.ok(album);
	}
	
/*	@GetMapping(value = "/album/{id}")
	    public ModelAndView messages() {
	        ModelAndView mav = new ModelAndView("album");
	        System.err.println("MOV");
	        //mav.addObject("messages", messageRepository.findAll());
	        return mav;
	    }*/
/* 	@GetMapping(value = "/album?id={id}")
	public Page<Album> getPage(@RequestParam("id") String id) {
		System.err.println("getting alb: "+id);
		return albumRepository.findAll(new PageRequest(0, 18));
	}*/
}

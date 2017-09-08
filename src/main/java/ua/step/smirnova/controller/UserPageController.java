package ua.step.smirnova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ua.step.smirnova.entities.Artist;
import ua.step.smirnova.entities.User;
import ua.step.smirnova.service.AlbumService;
import ua.step.smirnova.service.ArtistService;
import ua.step.smirnova.service.UserService;
import ua.step.smirnova.service.NewsService;

@Controller
public class UserPageController {
	
	private ArtistService artistService;
	private AlbumService albumService;
	private UserService userService;
	private NewsService newsService;

	@Autowired(required = true)
	public void setAuthorService(ArtistService artistService, AlbumService albumService, UserService userService,
			NewsService newsService) {
		this.artistService = artistService;
		this.albumService = albumService;
		this.userService = userService;
		this.newsService = newsService;
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUser(@PathVariable int id) {
		User user = userService.getUserById(id).get();
		return ResponseEntity.ok(user);
	}
}

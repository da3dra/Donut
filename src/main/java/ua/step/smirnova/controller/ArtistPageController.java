package ua.step.smirnova.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ua.step.smirnova.dto.UserCreateForm;
import ua.step.smirnova.entities.Artist;
import ua.step.smirnova.entities.User;
import ua.step.smirnova.service.AlbumService;
import ua.step.smirnova.service.ArtistService;
import ua.step.smirnova.service.UserService;

@Controller
public class ArtistPageController {

	private ArtistService artistService;
	private AlbumService albumService;
	private UserService userService;

	@Autowired(required = true)
	public void setAuthorService(ArtistService artistService, AlbumService albumService, UserService userService) {
		this.artistService = artistService;
		this.albumService = albumService;
		this.albumService = albumService;
		this.userService = userService;
	}

	@GetMapping("/artist/{id}")
	public ResponseEntity<?> getAlbumList(@PathVariable int id) {
		Artist artist = artistService.get(id);
		return ResponseEntity.ok(artist);
	}

	@PostMapping(value = "artist", params = "follower")
	public String follow(@RequestParam("id") int id, @RequestParam("follower") String follower,
			RedirectAttributes redirectAttributes) {
		Artist artist = artistService.get(id);
		// System.err.println("artist: "+artist);
		User user = userService.getUserById(Integer.valueOf(follower)).get();
		userService.follow(user, artist);
		redirectAttributes.addFlashAttribute("followMessage", "You are now following " + artist.getUsername() + "!");
		return "redirect:artist?id=" + id;
	}

	@PostMapping(value = "artist", params = "donater")
	public String donate(@RequestParam("id") int id, @RequestParam("donater") String donater,
			@Valid @ModelAttribute("donuts") String donuts, RedirectAttributes redirectAttributes) {
		Artist artist = artistService.get(id);
		int toGive = Integer.valueOf(donuts);
		User user = userService.getUserById(Integer.valueOf(donater)).get();
		boolean success = userService.donate(user, artist, toGive);
		if(!success){
			redirectAttributes.addFlashAttribute("donateMessage", "You have not enough donuts!");
			return "redirect:artist?id=" + id;
		}
		redirectAttributes.addFlashAttribute("donateMessage", "You donated "+donuts+" to " + artist.getUsername() + "!");
		return "redirect:artist?id=" + id;
	}
}

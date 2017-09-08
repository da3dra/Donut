package ua.step.smirnova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ua.step.smirnova.entities.Artist;
import ua.step.smirnova.entities.User;
import ua.step.smirnova.service.AlbumService;
import ua.step.smirnova.service.ArtistService;
import ua.step.smirnova.service.NewsService;
import ua.step.smirnova.service.UserService;

@Controller
public class DonationController {
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

	@PostMapping(value = "user/{id}/buyDonuts/{amount}")
	public String follow(@PathVariable int id, @PathVariable String amount, RedirectAttributes redirectAttributes) {
		User user = userService.getUserById(id).get();
		int bought = Integer.valueOf(amount);
		if (user.getDonuts() == null) {
			user.setDonuts(new Integer(0));
			userService.update(user);
		}
		user.setDonuts(user.getDonuts() + bought);
		userService.update(user);
		return "redirect:/";
	}
}

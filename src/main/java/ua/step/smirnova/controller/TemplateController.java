package ua.step.smirnova.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class TemplateController {

	@RequestMapping("/")
	public String main() {
		return "index";
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/search")
	public String search() {
		return "search";
	}

	@RequestMapping("/albums")
	public String albums() {
		return "albms";
	}

	@RequestMapping("/album")
	public String album() {
		return "album";
	}

	@RequestMapping("/artist/manage")
	public String manage() {
		return "/artist/manage";
	}

	@RequestMapping("/artist")
	public String artist() {
		return "/artist";
	}
	
	@RequestMapping("/admin/artists")
	public String adminArtists() {
		return "/admin/artists";
	}

	@RequestMapping("/admin/artist")
	public String adminArtist() {
		return "/admin/artist";
	}
	
	@RequestMapping("/user")
	public String user() {
		return "/user";
	}

	@RequestMapping("/bag")
	public String bag() {
		return "/bag";
	}

	@RequestMapping("/wishlist")
	public String wishlist() {
		return "/wishlist";
	}
	@RequestMapping("/buyDonuts")
	public String buyDonuts() {
		return "/buyDonuts";
	}
}
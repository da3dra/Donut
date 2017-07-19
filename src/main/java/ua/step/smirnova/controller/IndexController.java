package ua.step.smirnova.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.step.smirnova.entities.Track;
import ua.step.smirnova.service.TrackServiceImpl;

@Controller
@RequestMapping(value = "/")
public class IndexController {
/*	private TrackServiceImpl trackService;

	@Autowired(required = true)
	public void setTrackService(TrackServiceImpl trackService) {
		this.trackService = trackService;
	}*/
	  @RequestMapping("/")
	  public String main() {
	    return "index";
	  }

	  @RequestMapping("/index")
	  public String index() {
	    return "index";
	  }
	
	  @RequestMapping("/albums")
	  public String albums() {
	    return "albms";
	  }
	
}
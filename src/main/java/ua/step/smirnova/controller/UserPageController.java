package ua.step.smirnova.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class UserPageController {
	
	  @RequestMapping("/userpage")
	  public String login() {
	    return "userpage";
	  }
}

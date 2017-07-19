package ua.step.smirnova.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ua.step.smirnova.dto.UserCreateForm;
import ua.step.smirnova.service.UserService;
import ua.step.smirnova.validators.UserCreateFormValidator;
@Controller
public class UserController {
	
	//поменять на стр с id
	  @RequestMapping("/userpage")
	  public String login() {
	    return "userpage";
	  }
	  
	  private final UserService userService;
		private final UserCreateFormValidator userCreateFormValidator;

		@Autowired
		public UserController(UserService userService, UserCreateFormValidator userCreateFormValidator) {
			this.userService = userService;
			this.userCreateFormValidator = userCreateFormValidator;
		}

		@InitBinder("form")
		public void initBinder(WebDataBinder binder) {
			binder.addValidators(userCreateFormValidator);
		}

		/*@RequestMapping("/user/{id}")
		public ModelAndView getUserPage(@PathVariable Long id) {
			return new ModelAndView("user", "user", userService.getUserById(id)
					.orElseThrow(() -> new NoSuchElementException(String.format("User=%s not found", id))));
		}*/

		@RequestMapping(value = "/registration", method = RequestMethod.GET)
		public ModelAndView getUserCreatePage() {
			return new ModelAndView("registration", "form", new UserCreateForm());
		}

		@RequestMapping(value = "/registration", method = RequestMethod.POST)
		public String handleUserCreateForm(@Valid @ModelAttribute("form") UserCreateForm form,
				BindingResult bindingResult) {
			if (bindingResult.hasErrors()) {
				return "registration";
			}
			try {
				userService.create(form);
			} catch (DataIntegrityViolationException e) {
				bindingResult.reject("email.exists", "Email already exists");
				return "registration";
			}
			return "redirect:/login";
		}
}

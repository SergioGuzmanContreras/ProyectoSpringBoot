package mx.com.ersoft.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mx.com.ersoft.utils.ViewNamesService;

@Controller
public class LoginController {

	private static final Logger log = LoggerFactory.getLogger(LoginController.class);


	@GetMapping("/login")
	public String showLoginForm(Model model, @RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logOut", required = false) String logOut) {
		log.info("METHOD: showLoginForm() PARAMS: error=" + error + ", logOut:=" + logOut);
		model.addAttribute("logOut", logOut);
		model.addAttribute("error", error);
		return ViewNamesService.LOGIN_FORM;
	}

	@GetMapping({"/loginSuccess", "/"})
	public String loginCheck() {
		log.info("METHOD: loginCheck()");
		log.info("Returning to contacts view");
		return "redirect:/contacts/showContacts";
	}
}
	
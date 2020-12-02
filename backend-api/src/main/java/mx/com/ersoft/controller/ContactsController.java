package mx.com.ersoft.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mx.com.ersoft.model.ContactModel;
import mx.com.ersoft.service.ContactService;
import mx.com.ersoft.utils.ViewNamesService;

@Controller
@RequestMapping("/contacts")
public class ContactsController {

	private static final Logger log = LoggerFactory.getLogger(ContactsController.class);

	@Autowired
	private ContactService contactService;

	@PreAuthorize("hasRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/contactform")
	public String redirectContactForm(Model model, @RequestParam(name = "id", required = false) int id) {				
		model.addAttribute("contactModel",id==0? new ContactModel() : contactService.findContactById(id));
		return ViewNamesService.CONTACT_FORM;
	}

	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/contacts/showContacts";
	}

	@PostMapping("/addContact")
	public String addContact(Model model, @ModelAttribute(name = "contactModel") ContactModel contact) {
		log.info("Contacto agregado: " + contact);
		if (contactService.addContact(contact) != null)
			model.addAttribute("result", 1);
		else
			model.addAttribute("result", 0);
		return "redirect:/contacts/showContacts";
	}
	
	@GetMapping("/showContacts")
	public ModelAndView getContatcs() {
		ModelAndView mav = new ModelAndView(ViewNamesService.CONTACTS_VIEW);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("userName", user.getUsername());
		mav.addObject("contacts", contactService.getContacts());
		return mav;
	}
	
	@GetMapping("/removeContact")
	public ModelAndView deleteContact(@RequestParam(name = "id", required = true) int id) {
		contactService.removeContact(id);
		return this.getContatcs();
	}
}

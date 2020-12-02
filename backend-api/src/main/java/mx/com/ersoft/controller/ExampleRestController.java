package mx.com.ersoft.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.ersoft.model.ContactModel;

@RestController
@RequestMapping("/rest")
public class ExampleRestController {

	@GetMapping("/test")
	public ResponseEntity<ContactModel> checkRest(){
		ContactModel contact = new ContactModel(5, "Papu", "Desmadre", "Mexico", "12345");
		return new ResponseEntity<ContactModel>(contact, HttpStatus.OK);
	}
}

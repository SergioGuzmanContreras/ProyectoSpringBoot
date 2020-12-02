package mx.com.ersoft.service;

import java.util.List;

import mx.com.ersoft.model.ContactModel;

public interface ContactService {

	ContactModel addContact(ContactModel contactModel);
	List<ContactModel> getContacts();
	ContactModel findContactById(int id);
	void removeContact(int id);
	
}

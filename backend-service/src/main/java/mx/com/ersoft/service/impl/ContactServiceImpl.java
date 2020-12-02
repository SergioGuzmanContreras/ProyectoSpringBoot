package mx.com.ersoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.ersoft.dao.ContactDao;
import mx.com.ersoft.entity.ContactsEntity;
import mx.com.ersoft.model.ContactModel;
import mx.com.ersoft.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactDao contactDao;
	
	@Override
	public ContactModel addContact(ContactModel contactModel) {			
		return converterContact(contactDao.save(converterContact(contactModel)));
	}

	
	private ContactsEntity converterContact(ContactModel model) {
		ContactsEntity entity = new ContactsEntity();
		entity.setCity(model.getCity());
		entity.setFirstName(model.getFirstName());
		entity.setLastName(model.getLastName());
		entity.setTelephone(model.getTelephone());
		entity.setId(model.getId());
		return entity;
	}
	
	private ContactModel converterContact(ContactsEntity model) {
		ContactModel entity = new ContactModel();
		entity.setCity(model.getCity());
		entity.setFirstName(model.getFirstName());
		entity.setLastName(model.getLastName());
		entity.setTelephone(model.getTelephone());
		entity.setId(model.getId());
		return entity;
	}


	@Override
	public List<ContactModel> getContacts() {
		List<ContactsEntity> lstContacts = contactDao.findAll();
		List<ContactModel> lst = new ArrayList<>();
		lstContacts.forEach(w ->{
			lst.add(converterContact(w));
		});
		return lst;
	}


	@Override
	public ContactModel findContactById(int id) {
		return converterContact(contactDao.findByid(id));
	}


	@Override
	public void removeContact(int id) {
		contactDao.delete(converterContact(findContactById(id)));
	}
}

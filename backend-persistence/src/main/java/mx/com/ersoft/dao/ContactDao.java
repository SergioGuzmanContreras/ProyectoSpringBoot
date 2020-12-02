package mx.com.ersoft.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.ersoft.entity.ContactsEntity;

@Repository
public interface ContactDao extends JpaRepository<ContactsEntity, Serializable>{


	ContactsEntity findByid(int id);
	
}

package mx.com.ersoft.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.ersoft.entity.UserEntity;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Serializable>{

	UserEntity findByUserName(String username);
	
}

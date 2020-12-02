package mx.com.ersoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import mx.com.ersoft.dao.UserDao;
import mx.com.ersoft.entity.UserEntity;

@Service
public class UserServiceImpl implements UserDetailsService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("<- ### UserName: " + username + " ###->");

		UserEntity us = userDao.findByUserName(username);
		List<GrantedAuthority> auths = new ArrayList<>();
		us.getUserRole().forEach(w ->{
			auths.add(new SimpleGrantedAuthority(w.getRole()));
			log.info(w.getRole());
		});
		return new User(us.getUserName(), us.getPassword(), us.isEnabled(), true, true, true, auths);
	}


}

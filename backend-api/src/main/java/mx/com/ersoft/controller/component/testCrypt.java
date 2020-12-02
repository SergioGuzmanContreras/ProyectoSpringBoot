package mx.com.ersoft.controller.component;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class testCrypt {


	public static void main(String[] args) {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		System.out.println(pe.encode("user"));

	}

}

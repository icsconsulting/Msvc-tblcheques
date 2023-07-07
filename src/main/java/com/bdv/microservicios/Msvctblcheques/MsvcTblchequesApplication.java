package com.bdv.microservicios.Msvctblcheques;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class MsvcTblchequesApplication {

	public static void main(String[] args) {

		SpringApplication.run(MsvcTblchequesApplication.class, args);
		//BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		//String encodedPassword = passwordEncoder.encode("Microserviciotblchequesownerpassword");

		//System.out.println(encodedPassword);

	}

}

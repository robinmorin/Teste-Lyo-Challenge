package br.com.teste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.teste")
public class CrudSimplesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSimplesApplication.class, args);
	}

}

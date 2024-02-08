package org.github.falingsumo.TBSARPG.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Server {
	public static void main(String[] args) {
		SpringApplication.run(Server.class, args);
	}

	@RequestMapping("/")
	public String home() {
		return "test";
	}
}

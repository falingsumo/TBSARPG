package org.github.falingsumo.TBSARPG.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Server {
	private static final String CONTEXT_PATH = "/api";
	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", CONTEXT_PATH);
		SpringApplication.run(Server.class, args);
	}
}

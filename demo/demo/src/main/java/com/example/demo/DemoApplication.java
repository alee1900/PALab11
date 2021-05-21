package com.example.demo;

import com.example.demo.services.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping
	public static String runCommands() {
		return "<h1>" + PersonService.addPersonByName("1", "Alecsandra") + "</h1>\n<h1>" +
				"<h1>" + PersonService.addPersonByName("2", "Andra") + "</h1>\n<h1>" +
				"<h1>" + PersonService.addPersonByName("3", "Irina") + "</h1>\n<h1>" +
				PersonService.updatePerson("1", "Alexandra") + "</h1>\n<h1>" +
				PersonService.getPersonList() + "</h1>\n<h1>";
	}
}

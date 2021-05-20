package com.example.demo;

import com.example.demo.services.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		runCommands();
	}

	@RequestMapping
	public static String runCommands() {
		return "<h1>" + Service.addPersonByName("1", "Alecsandra") + "</h1>\n<h1>" +
				"<h1>" + Service.addPersonByName("2", "Andra") + "</h1>\n<h1>" +
				"<h1>" + Service.addPersonByName("3", "Irina") + "</h1>\n<h1>" +
				Service.updatePerson("1", "Alexandra") + "</h1>\n<h1>" +
				Service.getPersonList() + "</h1>\n<h1>";
	}
}

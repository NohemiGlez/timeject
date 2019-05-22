package com.timeject.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
public class IndexController {

	@GetMapping("/")
	public String home(Model model) {
		return "index.html";
	}
}
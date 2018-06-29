package com.spring.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.demo.form.Sentence;

@Controller
public class HomeController {
	
	/**
	 * Initializing logger for this class
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/")
	public String showMessage(Model model) {
		LOGGER.info("Landing page");
		model.addAttribute("sentence", new Sentence());
 		return "index";
	}
}

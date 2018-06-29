package com.spring.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.demo.form.Sentence;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String showMessage(Model model) {
		model.addAttribute("sentence", new Sentence());
 		return "index";
	}
}


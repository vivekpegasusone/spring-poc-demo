package com.spring.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.demo.form.Sentence;
import com.spring.demo.service.WordControllerService;
 
@Controller
public class WordCounterController {
 
	private final WordControllerService service;
	
	@Autowired
	public WordCounterController(WordControllerService service) {
		this.service = service;
	}

	@PostMapping("/processSentence")
	public ModelAndView showMessage(@ModelAttribute("sentence") Sentence sentence) {
		System.out.println(sentence.getText());
		System.out.println(sentence.getSortedBy());
		Map<String, Long> map = service.getWordOccurrences(sentence.getText(), sentence.getSortedBy());
		sentence.setWordOccurrence(map);
		
		map.entrySet().stream().forEach(s -> System.out.println(s.getKey() + " : (" + s.getValue() + ")"));
		
		return new ModelAndView("wordCounter", "result", sentence);
	}		
}



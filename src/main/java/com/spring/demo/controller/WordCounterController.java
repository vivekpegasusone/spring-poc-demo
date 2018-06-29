package com.spring.demo.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.demo.form.Sentence;
import com.spring.demo.service.WordControllerService;
 
@Controller
public class WordCounterController {
	
	/**
	 * Initializing logger for this class
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(WordCounterController.class);
 
	private final WordControllerService service;
	
	@Autowired
	public WordCounterController(WordControllerService service) {
		this.service = service;
	}

	@PostMapping("/processSentence")
	public ModelAndView showMessage(@ModelAttribute("sentence") Sentence sentence) {
		LOGGER.debug("Received sentence form values: {}", sentence);
		Map<String, Long> map = service.getWordOccurrences(sentence.getText(), sentence.getSortedBy());
		sentence.setWordOccurrence(map);
		
		map.entrySet().stream().forEach(s -> System.out.println(s.getKey() + " : (" + s.getValue() + ")"));
		
		return new ModelAndView("wordCounter", "result", sentence);
	}		
}

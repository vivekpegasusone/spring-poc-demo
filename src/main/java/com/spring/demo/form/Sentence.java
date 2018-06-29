package com.spring.demo.form;

import java.util.Map;

public class Sentence {
	private String text;
	private String sortedBy;
	private Map<String, Long> wordOccurrence;
	
	public Sentence() {
		super();
	}

	public Sentence(String text, String sortedBy) {
		super();
		this.text = text;
		this.sortedBy = sortedBy;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSortedBy() {
		return sortedBy;
	}

	public void setSortedBy(String sortedBy) {
		this.sortedBy = sortedBy;
	}

	public Map<String, Long> getWordOccurrence() {
		return wordOccurrence;
	}

	public void setWordOccurrence(Map<String, Long> wordOccurrence) {
		this.wordOccurrence = wordOccurrence;
	}	
}

package com.spring.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class WordControllerServiceTest extends WordControllerService {
	
	WordControllerService service = new WordControllerService();

	@Test
	public void testGetWordOccurrences() {
		String text = "a quick brown fox jumped over a lazy dog";
		String sorBy = "occurrence";
		Map<String, Long> response = service.getWordOccurrences(text, sorBy);
		Assert.assertNotNull(response);
		Assert.assertEquals(8, response.size());
		Assert.assertEquals(2, response.get("a").intValue());
		Assert.assertEquals(1, response.get("quick").intValue());
		Assert.assertEquals(1, response.get("brown").intValue());
		Assert.assertEquals(1, response.get("fox").intValue());
		Assert.assertEquals(1, response.get("jumped").intValue());
		Assert.assertEquals(1, response.get("over").intValue());
		Assert.assertEquals(1, response.get("lazy").intValue());
		Assert.assertEquals(1, response.get("dog").intValue());
	}
	
	@Test
	public void testGetWordAlphabetically() {
		String text = "a quick brown fox jumped over a lazy dog";
		String sorBy = "alphabetically";
		Map<String, Long> response = service.getWordOccurrences(text, sorBy);
		List<String> keyList = new ArrayList<>();
		for(String key: response.keySet()) {
			keyList.add(key);
		}
		
		Collections.sort(keyList);
		
		Assert.assertNotNull(response);
		
		int i = 0;
		for(String key: response.keySet()) {
			Assert.assertEquals(keyList.get(i++), key);
		}		
	}
	
	@Test
	public void testGetWordOccurrencesWithEmptyText() {
		String text = "";
		String sorByOccurance = "";
		Map<String, Long> response = service.getWordOccurrences(text, sorByOccurance);
		Assert.assertNotNull(response);
		Assert.assertEquals(true, response.isEmpty());
	}
	
	@Test
	public void testGetWordOccurrencesWithEmptyTextSortByOccurence() {
		String text = "";
		String sorBy = "occurrence";
		Map<String, Long> response = service.getWordOccurrences(text, sorBy);
		Assert.assertNotNull(response);
		Assert.assertEquals(true, response.isEmpty());
	}
	
	@Test
	public void testGetWordOccurrencesWithEmptyTextSortByAlphabatically() {
		String text = "";
		String sorBy = "alphabetically";
		Map<String, Long> response = service.getWordOccurrences(text, sorBy);
		Assert.assertNotNull(response);
		Assert.assertEquals(true, response.isEmpty());
	}

}

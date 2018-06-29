package com.spring.demo.service;

import static java.util.Map.Entry.comparingByKey;
import static java.util.stream.Collectors.toMap;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

@Service
public class WordControllerService {

	public Map<String, Long> getWordOccurrences(String text, String sortedby) {
		Map<String, Long> wordCounter = new LinkedHashMap<String, Long>();
		
		if(!text.trim().isEmpty()) {
			Stream<String> stream = Stream.of(text.toLowerCase().split("\\s"));
			Map<String, Long> map = stream.collect(Collectors.groupingBy(String::toString,Collectors.counting()));
			
			switch(Order.getEnum(sortedby)) {
				case ALPHABETICALLY :
					wordCounter = map.entrySet().stream().sorted(comparingByKey()).collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
					break;
					
				case BY_OCCURRENCE :
					wordCounter = map.entrySet().stream().sorted(new Comparator<Map.Entry<String, Long>>(){
						@Override
					      public int compare(Map.Entry<String, Long> e1, Map.Entry<String, Long> e2) {
					         if(e1.getValue().equals(e2.getValue())){
					           return e1.getKey().compareTo(e2.getKey());
					         }else {
					           return e2.getValue().compareTo(e1.getValue());
					         }
					      }}).collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
					break;
			}
		}
				
		return wordCounter;		
	}	
	
}

package com.spring.demo.service;

public enum Order {
	ALPHABETICALLY("alphabetically"), BY_OCCURRENCE("occurrence");
	
	private String value;

	private Order(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public static Order getEnum(String value){
	    for(Order e : Order.values()) {
	      if(e.value.equals(value)) {
	    	  return e;
	      }
	    }
	    return null;
	}
}

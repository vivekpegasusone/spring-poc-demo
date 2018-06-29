package com.spring.demo.tag;

import java.io.IOException;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DemoTag extends SimpleTagSupport{

	private Map<String, Long> value;
		
	@Override
    public void doTag() throws JspException, IOException {
		final JspWriter writer = getJspContext().getOut();
        if (value != null && !value.isEmpty()) {
        	writer.print("<ul>");
        	for(Map.Entry<String, Long> entry : value.entrySet()){
        		writer.print("<li> " + entry.getKey() + " (" + entry.getValue() + ") </li>");
        	}  
        	writer.print("</ul>");
        }       
    }
	
	/**
	 * @param map the map to set
	 */
	public void setValue(Map<String, Long> value) {
		this.value = value;
	}
}

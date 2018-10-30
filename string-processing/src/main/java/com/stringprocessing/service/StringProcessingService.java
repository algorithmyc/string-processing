package com.stringprocessing.service;

import org.springframework.stereotype.Component;

@Component("stringProcessingService")
public interface StringProcessingService {

	public String getStringManipulation(String value);
	
	public boolean isContainingNumber(String s);

	public String getNumberToWords(int value);

}

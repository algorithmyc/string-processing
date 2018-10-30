package com.stringprocessing.service;

import org.springframework.stereotype.Component;

@Component("stringProcessingService")
public interface StringProcessingService {

	public String getStringManipulation(String value);


	public String getNumberToWords(String value);

}

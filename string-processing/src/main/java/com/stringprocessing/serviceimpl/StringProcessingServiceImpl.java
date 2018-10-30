package com.stringprocessing.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stringprocessing.service.StringProcessingService;
import com.stringprocessing.utility.NumberToWords;
import com.stringprocessing.utility.StringManipulation;

@Service
public class StringProcessingServiceImpl implements StringProcessingService {

	@Autowired
	private StringManipulation stringManip;

	@Autowired
	private NumberToWords numberToWords;

	@Override
	public String getStringManipulation(String value) {

		return stringManip.removeDoubleLettersSet(value);

	}

	@Override
	public boolean isContainingNumber(String s) {
		// TODO Auto-generated method stub
		return stringManip.isContainingNumber(s);
	}

	@Override
	public String getNumberToWords(int value) {

		return numberToWords.convert(value);

	}

}

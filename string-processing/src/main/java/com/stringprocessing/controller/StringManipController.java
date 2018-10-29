package com.stringprocessing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stringprocessing.exception.ResourceNotFoundException;
import com.stringprocessing.model.ProcessedString;
import com.stringprocessing.utility.NumberToWords;
import com.stringprocessing.utility.StringManipulation;

@Controller
public class StringManipController {

	@Autowired
	private StringManipulation stringManip;

	@Autowired
	private NumberToWords numberToWords;

	private String result;

	private String number;

	@GetMapping("/")
	@ResponseBody
	public String home(@RequestParam(name = "value", required = false, defaultValue = "") String value) {

		return "Welcome to the String Processing Application";
	}

	@GetMapping("/stringDedup")
	@ResponseBody
	public ProcessedString doManip(@RequestParam(name = "value", required = false, defaultValue = "") String value) {

		if (value != null) {
			result = stringManip.removeDoubleLettersSet(value);
		}

		return new ProcessedString(result);

	}

	@GetMapping("/writeNumber")
	@ResponseBody
	public ProcessedString getWriteNumber(
			@RequestParam(name = "value", required = false, defaultValue = "0") int value) {

		if (value != 0 && String.valueOf(value) != "") {
			number = numberToWords.convert(value);
		}

		return new ProcessedString(number);

	}

}

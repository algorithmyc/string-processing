package com.stringprocessing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stringprocessing.exception.ResourceNotFoundException;
import com.stringprocessing.model.ProcessedString;
import com.stringprocessing.service.StringProcessingService;

@Controller
public class StringManipController {

	@Autowired
	private StringProcessingService stringProcessingService;

	@GetMapping("/")
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseBody
	public String home(@RequestParam(name = "value", required = false, defaultValue = "") String value) {

		return "Welcome to the String Processing Application";
	}

	@GetMapping("/stringDedup")
	@ResponseBody
	public ProcessedString doManip(@RequestParam(name = "value", required = false, defaultValue = "") String value) {

		String result = stringProcessingService.getStringManipulation(value);

		return new ProcessedString(result);

	}

	@GetMapping("/writeNumber")
	@ResponseBody
	public ProcessedString getWriteNumber(
			@RequestParam(name = "value", required = false, defaultValue = "") String value) {

		String number = stringProcessingService.getNumberToWords(value);

		return new ProcessedString(number);

	}

}

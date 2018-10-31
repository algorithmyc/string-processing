package com.stringprocessing.test.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.stringprocessing.controller.StringManipController;
import com.stringprocessing.service.StringProcessingService;

@RunWith(SpringRunner.class)
@WebMvcTest(StringManipController.class)
public class StringManipControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StringProcessingService service;

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Welcome to the String Processing Application")));
	}

	@Test
	public void stringDedupShouldReturnProcessedStringFromService() throws Exception {

		when(service.getStringManipulation("ceciestunechaine")).thenReturn("acehinstu");

		this.mockMvc.perform(get("/stringDedup?value=ceciestunechaine")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("acehinstu")));
	}

	@Test
	public void writeNumberShouldReturnWordFromService() throws Exception {

		when(service.getNumberToWords("5962")).thenReturn("Five Thousand Nine Hundred Sixty Two ");

		this.mockMvc.perform(get("/writeNumber?value=5962")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Five Thousand Nine Hundred Sixty Two ")));
	}

}

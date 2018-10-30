package com.stringprocessing.test.application;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stringprocessing.controller.StringManipController;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {

	@Autowired
	private StringManipController controller;

	@Test
	public void contextLoads() throws Exception {

	}

	@Test
	public void contextLoadsIsNotNull() throws Exception {
		assertThat(controller).isNotNull();
	}

}

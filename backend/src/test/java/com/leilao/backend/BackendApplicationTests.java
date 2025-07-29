package com.leilao.backend;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.leilao.backend.controller.Hello;

@SpringBootTest
class BackendApplicationTests {
	@Autowired
	private Hello controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}

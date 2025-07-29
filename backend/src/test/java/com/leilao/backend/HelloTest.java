package com.leilao.backend;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
                String.class)).contains("Olá, Spring");
    }

    @Test
    void deveSomarDoisNumeros() {
        // Dado (Given): valores de entrada para a operação de soma
        int v1 = 2;
        int v2 = 2;
        String baseUrl = String.format("http://localhost:%d/calc/somar", port);
        String url = String.format("%s?v1=%d&v2=%d", baseUrl, v1, v2);

        // Quando (When): uma requisição GET é feita com os parâmetros
        String responseBody = restTemplate.getForObject(url, String.class);
        System.out.println(responseBody);

        // Então (Then): o resultado retornado deve ser "4"
        assertThat(responseBody).isEqualTo("4");

        // Alternativa com getForEntity:
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        System.out.println(responseEntity);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isEqualTo("4");
    }

}

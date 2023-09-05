package com.example.carros;

import com.example.carros.domain.Carro;
import com.example.carros.domain.CarroService;
import com.example.carros.domain.dto.CarroDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CarrosApplicationTests {

	@Autowired
	private CarroService service;

	@Test
	public void test1() {
		Carro carro = new Carro();
		carro.setNome("Ferrari");
		carro.setTipo("Esportivo");

		service.insert(carro);

//		assertNotNull(c);
	}
	@Test
	void contextLoads() {
		Carro carro = new Carro();
		carro.setNome("Ferrari");
		carro.setTipo("Esportivo");

//
//		assertNotNull(c);
	}

}

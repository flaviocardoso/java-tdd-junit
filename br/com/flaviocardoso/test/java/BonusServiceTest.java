package br.com.flaviocardoso.test.java;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.flaviocardoso.tdd.modelo.Funcionario;
import br.com.flaviocardoso.tdd.service.BonusService;

class BonusServiceTest {

	@Test
	void funcionarioComSalarioAcimaDe1000EZero() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("jjjjj", LocalDate.now(), new BigDecimal("25000")));
		assertEquals(new BigDecimal("0.00"), bonus);
	}
	
	@Test
	void funcionario10PorcentoDoSalario() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("jjjjj", LocalDate.now(), new BigDecimal("2500")));
		assertEquals(new BigDecimal("250.00"), bonus);
	}
	
	@Test
	void funcionarioExatamente10000Salario() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("jjjjj", LocalDate.now(), new BigDecimal("10000")));
		assertEquals(new BigDecimal("1000.00"), bonus);
	}

}

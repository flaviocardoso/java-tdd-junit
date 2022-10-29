package br.com.flaviocardoso.test.java;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.flaviocardoso.tdd.modelo.Desempenho;
import br.com.flaviocardoso.tdd.modelo.Funcionario;
import br.com.flaviocardoso.tdd.service.ReajusteService;

class ReajusteServiceTest {

	private ReajusteService service;
	private Funcionario funcionario;
	
	@BeforeEach
	public void inicializar() { // antes de cada metodo de teste
		System.out.println("inicializa");
		this.service = new ReajusteService();
		this.funcionario = new Funcionario("", LocalDate.now(), new BigDecimal("1000.00"));
	}
	
	@AfterEach
	public void finalizar() { // depois de cada metodo de teste
		System.out.println("fim");
	}
	
	@BeforeAll
	public static void antesDeTodos() { // executa uma única vezes antes de todos
		System.out.println("antes de todos"); // cromometrar tempo, banco de dados, arquivos
	}
	
	@AfterAll
	public static void depoisDeTodos() { // executa uma única vezes depois de todos
		System.out.println("depois de todos"); // cromometrar tempo, banco de dados, arquivos
	}

	@Test
	void reajusteTresPorcentoQuandoForDesempenhoAdesejar() {
		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}
	
	@Test
	void reajusteTresPorcentoQuandoForDesempenhoBom() {
		service.concederReajuste(funcionario, Desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}
	
	@Test
	void reajusteTresPorcentoQuandoForDesempenhoOtimo() {
		service.concederReajuste(funcionario, Desempenho.OTIMO);
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}

}

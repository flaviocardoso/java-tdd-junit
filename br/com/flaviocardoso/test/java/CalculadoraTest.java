package br.com.flaviocardoso.test.java;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.com.flaviocardoso.tdd.modelo.Calculadora;

public class CalculadoraTest {

	@Test
	public void somaDoisNumerosPositivos() {
		Calculadora calc = new Calculadora();
		int soma = calc.soma(5, 15);
		
		Assert.assertEquals(20, soma);
	}
}

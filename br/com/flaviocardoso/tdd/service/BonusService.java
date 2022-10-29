package br.com.flaviocardoso.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.flaviocardoso.tdd.modelo.Funcionario;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		if (valor.compareTo(new BigDecimal("1000")) > 0) {
			// valor = new BigDecimal("0.00");
			throw 	new IllegalArgumentException("Funcionario com o salario maior do R$10000,00 não pode receber bonus!");
		}
		return valor.setScale(2, RoundingMode.HALF_UP);
	}

}

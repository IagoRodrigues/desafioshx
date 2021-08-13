package br.com.iago.desafioshx.controller;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import br.com.iago.desafioshx.model.Moeda;

public class CurrencyController {
	
	@RequestMapping("/listarTodos")
	public List<Moeda> listarMoedas() {
		Moeda moeda1 = new Moeda(1.00, new Timestamp(System.currentTimeMillis()));
		Moeda moeda2 = new Moeda(2.00, new Timestamp(System.currentTimeMillis()));
		Moeda moeda3 = new Moeda(3.00, new Timestamp(System.currentTimeMillis()));
		
		return Arrays.asList(moeda1, moeda2, moeda3);
	}

}

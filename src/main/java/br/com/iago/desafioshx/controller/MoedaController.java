package br.com.iago.desafioshx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.iago.desafioshx.model.Moeda;
import br.com.iago.desafioshx.model.MoedaDto;
import br.com.iago.desafioshx.repository.MoedaRepository;

@RestController
public class MoedaController {
	
	@Autowired
	private MoedaRepository moedaRepository;
	
	@RequestMapping("/listarCotacoes")
	public List<MoedaDto> listarCotacoes() {
		List<Moeda> cotacoes = moedaRepository.findAll();
		return MoedaDto.converter(cotacoes);
	}
}

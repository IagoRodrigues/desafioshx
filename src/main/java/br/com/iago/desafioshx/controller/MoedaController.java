package br.com.iago.desafioshx.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.iago.desafioshx.client.ClientFeign;
import br.com.iago.desafioshx.model.Moeda;
import br.com.iago.desafioshx.model.MoedaDTO;
import br.com.iago.desafioshx.repository.MoedaRepository;

@RestController
public class MoedaController {
	
	@Autowired
	private MoedaRepository moedaRepository;
	
	@Autowired
	private ClientFeign feign;
	
	@RequestMapping("/listarCotacoes")
	public List<MoedaDTO> listarCotacoes() {
		List<Moeda> cotacoes = moedaRepository.findAll();
		return MoedaDTO.converter(cotacoes);
	}
	
	@RequestMapping("/filtroPorData/date")
	public ResponseEntity<List<Moeda>> listarPorData(@RequestParam("dataInicial") @DateTimeFormat(pattern="dd-MM-yyyyHH:mm:ss") Date dataInicial,
			@RequestParam("dataFinal") @DateTimeFormat(pattern="dd-MM-yyyyHH:mm:ss") Date dataFinal){
		
		List<Moeda> cotacoes = moedaRepository.findPorData(dataInicial, dataFinal);
									
		return ResponseEntity.ok(cotacoes);
	}
	
	@RequestMapping("/filtroPorData/string")
	public ResponseEntity<List<Moeda>> listarPorData(@RequestParam("dataInicial") String dataInicial,
			@RequestParam("dataFinal") String dataFinal){
		List<Moeda> cotacoes = null;
		
		try {
			Date dataINI = new SimpleDateFormat("dd-MM-yyyyHH:mm:ss").parse(dataInicial);
			Date dataFIN = new SimpleDateFormat("dd-MM-yyyyHH:mm:ss").parse(dataFinal);
			cotacoes = moedaRepository.findPorData(dataINI, dataFIN);
		} catch (ParseException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
											
		return ResponseEntity.ok(cotacoes);
	}
	
	@RequestMapping("/listarCotacaoAtual")
	public List<Moeda> listarCotacaoAtual() {
		return feign.getMoeda();
	}
}

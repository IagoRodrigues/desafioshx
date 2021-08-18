package br.com.iago.desafioshx.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.iago.desafioshx.client.ClientFeign;
import br.com.iago.desafioshx.model.Moeda;
import br.com.iago.desafioshx.model.MoedaDTO;
import br.com.iago.desafioshx.repository.MoedaRepository;

/**
 * 
 * <h1>This class represents a Controller</h1>
 *
 * Methods:</br>
 * listarCotacoes();</br>
 * listarPorData(Date DataInicial, Date DataFinal);</br>
 * listarPorData(String DataInicial, String DataFinal);</br>
 * listarCotacaoAtual();</br>
 * 
 */
@RestController
@Component @EnableScheduling 
public class MoedaController {
	
	private final long SEGUNDO = 1000;
	private final long MINUTO = SEGUNDO * 60;
	
	@Autowired
	private MoedaRepository moedaRepository;
	
	@Autowired
	private ClientFeign feign;
	
	/**
	 * This method brings a list with all the currency prices in the database.
	 * 
	 * @return MoedaDTO with value and timeStamp
	 */
	@RequestMapping(value = "/listarCotacoes" , method = RequestMethod.GET)
	public List<MoedaDTO> listarCotacoes() {
		List<Moeda> cotacoes = moedaRepository.findAll();
		return MoedaDTO.converter(cotacoes);
	}
	
	/**
	 * This method brings a list with the currency prices filtered by Java Date.</br>
	 * Date format: dd-MM-yyyyHH:mm:ss</br>
	 * 
	 * @param dataInicial (From date)
	 * @param dataFinal (To date)
	 * @return  MoedaDTO with value and timeStamp
	 */
	@RequestMapping(value = "/filtroPorData/date" , method = RequestMethod.GET)
	public ResponseEntity<List<MoedaDTO>> listarPorData(@RequestParam("dataInicial") @DateTimeFormat(pattern="dd-MM-yyyyHH:mm:ss") Date dataInicial,
			@RequestParam("dataFinal") @DateTimeFormat(pattern="dd-MM-yyyyHH:mm:ss") Date dataFinal){
		
		List<Moeda> cotacoes = moedaRepository.findPorData(dataInicial, dataFinal);
									
		return ResponseEntity.ok(MoedaDTO.converter(cotacoes));
	}
	
	/**
	 * This method brings a list with the currency prices filtered by a data by string.</br>
	 * Example for testing the filter: </br>
	 * http://localhost:8080/filtroPorData/string?dataInicial=15-04-201900:00:00&dataFinal=15-04-202124:00:00
	 * 
	 * @param dataInicial (From date)
	 * @param dataFinal (To date)
	 * @return MoedaDTO with value and timeStamp
	 */
	@RequestMapping(value = "/filtroPorData/string" , method = RequestMethod.GET)
	public ResponseEntity<List<MoedaDTO>> listarPorData(@RequestParam("dataInicial") String dataInicial,
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
											
		return ResponseEntity.ok(MoedaDTO.converter(cotacoes));
	}
	
	/**
	 * This method makes a request to Feign, </br>
	 * which makes a request for the external API,</br>
	 * and brings the actual price of the currency</br>
	 * 
	 * @return Moeda from external API
	 */
	@RequestMapping(value = "/listarCotacaoAtual" , method = RequestMethod.GET)
	public List<Moeda> listarCotacaoAtual() {
		return feign.getMoeda();
	}
	
	/**
	 * This method calls listarCotacaoAtual(), which return a list of Moeda. </br> 
	 * Then it takes the first position of the list and 
	 * saves it in the database.</br>
	 * 
	 * We are using Schedule to control time and makes one call per minute.</br>
	 */
	@Scheduled(fixedDelay = MINUTO) 
	public void inserirMoeda() {
		moedaRepository.save(listarCotacaoAtual().get(0));
	}
}

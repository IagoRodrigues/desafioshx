package br.com.iago.desafioshx.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.iago.desafioshx.model.Moeda;

/**
 * 
 * <h1>This interface is a Feign client</h1>
 * 
 * Used for Feign to call the currency API and bring a JSON</br>
 * with all data mapped on class Moeda. This conversion from</br>
 * JSON to Moeda is all made by Feign.</br>
 *
 */
@FeignClient(name = "moeda", url = "https://economia.awesomeapi.com.br/json")
public interface ClientFeign {
	
	@RequestMapping(method = RequestMethod.GET, value = "/USD-BRL")
	List<Moeda> getMoeda();
}
